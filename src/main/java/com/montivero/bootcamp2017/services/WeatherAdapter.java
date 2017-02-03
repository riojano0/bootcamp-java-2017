package com.montivero.bootcamp2017.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.montivero.bootcamp2017.builders.*;
import com.montivero.bootcamp2017.domains.Country;
import com.montivero.bootcamp2017.domains.ForecastExtended;
import com.montivero.bootcamp2017.domains.State;
import com.montivero.bootcamp2017.domains.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class WeatherAdapter {

    @Resource
    private WeatherServiceRest weatherServiceRest;

    @Autowired
    private CountryProxy countryProxy;

    @Autowired
    private StateProxy stateProxy;

    private static HashMap<String, Integer> days;

    static {
        days = new HashMap<String, Integer>();
        days.put("Sun", 1);
        days.put("Mon", 2);
        days.put("Tue", 3);
        days.put("Wed", 4);
        days.put("Thu", 5);
        days.put("Fri", 6);
        days.put("Sat", 7);
    }

    public Weather getWeather(String countryName, String stateName) {
        Weather weather = null;
        try {
            String query="select location,wind,atmosphere,item.condition,item.forecast,description from weather.forecast where woeid in (select woeid from geo.places(1) WHERE text%3d%22"+countryName+",+"+stateName+"%22)";
            String format="json";

            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(weatherServiceRest.getWeather(query, format));
            JsonNode results = actualObj.get("query").get("results");
            JsonNode weatherJson = results.get("channel");
            JsonNode countryJson = weatherJson.get(0).get("location");
            JsonNode windJson = weatherJson.get(0).get("wind");
            JsonNode atmosphereJson = weatherJson.get(0).get("atmosphere");
            JsonNode forecastTodayJson = weatherJson.get(0).get("item").get("condition");

            List<String> forecastListString = new ArrayList<String>();
            for(JsonNode s:weatherJson){
                if(s.get("item")!=null)
                    forecastListString.add(s.get("item").get("forecast").toString());
            }

            JsonNode forecastExtendedJson =  mapper.readTree(forecastListString.toString());

            List<ForecastExtended> forecastExtendedList = new ArrayList<ForecastExtended>();
            for (JsonNode fExt : forecastExtendedJson) {
                forecastExtendedList.add(new ForecastExtendedBuilder()
                        .date(fExt.get("date").textValue())
                        .dayId(days.get(fExt.get("day").textValue()))
                        .description(fExt.get("text").textValue())
                        .tempMin(fExt.get("low").asInt())
                        .tempMax(fExt.get("high").asInt())
                        .build());
            }

            Country country=null;
            for(Country c:countryProxy.getAllCountries()) {
                if (c.getShortName2().equals(countryJson.get("region").textValue().replaceAll("\\s+",""))) {
                    country = c;
                }
            }

            State state=null;
            assert country != null;
            for(State s: stateProxy.getStatesByCountry(country.getShortName3())){
                if(s.getName().equals(countryJson.get("city").textValue()))
                    state=s;
            }

            weather = new WeatherBuilder()
                    .wind(new WindBuilder()
                            .speed(windJson.get("speed").asInt())
                            .direction(windJson.get("direction").asInt())
                            .build())
                    .atmosphere(new AtmosphereBuilder()
                            .humidity(atmosphereJson.get("humidity").asInt())
                            .pressure(atmosphereJson.get("pressure").asDouble())
                            .rising(atmosphereJson.get("rising").asInt())
                            .visibility(atmosphereJson.get("visibility").asDouble())
                            .build())
                    .today(new ForecastTodayBuilder()
                            .date(forecastTodayJson.get("date").textValue())
                            .temp(forecastTodayJson.get("temp").asInt())
                            .build())
                    .week(forecastExtendedList)
                    .state(state)
//                    .state(new StateBuilder().country(country).build())
                    .description(weatherJson.get(0).get("description").textValue())
                    .build();

            return weather;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (NullPointerException e) {
            return null;
            }
        }


    }
