package com.montivero.bootcamp2017.adapters;

import com.montivero.bootcamp2017.builders.*;
import com.montivero.bootcamp2017.domains.ForecastExtended;
import com.montivero.bootcamp2017.domains.Weather;
import com.sun.jersey.api.client.Client;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeatherJsonAdapter {

    private JSONObject response;
    private JSONArray jsonArray;
    private static HashMap <String,Integer> days;
    static {
        days = new HashMap<String,Integer>();
        days.put("Sun",1);
        days.put("Mon",2);
        days.put("Tue",3);
        days.put("Wed",4);
        days.put("Thu",5);
        days.put("Fri",6);
        days.put("Sat",7);
    }

    String url ="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22nome%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

    public WeatherJsonAdapter() {
        Client c = Client.create();
        String responseString = c.resource(url)
                .accept("application/json; charset=utf-8")
                .get(String.class);
        this.response = new JSONObject(responseString).getJSONObject("query");
    }

    public Weather getWeather(){
        Weather w = null;

        JSONObject weatherJson = this.response.getJSONObject("results").getJSONObject("channel");
        JSONObject windJson = weatherJson.getJSONObject("wind");
        JSONObject countryJson = weatherJson.getJSONObject("location");
        JSONObject atmosphereJson = weatherJson.getJSONObject("atmosphere");
        JSONObject forecastTodayJson = weatherJson.getJSONObject("item").getJSONObject("condition");
        JSONArray forecastExtendedJson = weatherJson.getJSONObject("item").getJSONArray("forecast");


        List<ForecastExtended> forecastExtendedList = new ArrayList<ForecastExtended>();
        for(int i=0;i<forecastExtendedJson.length();i++){
            forecastExtendedList.add(new ForecastExtendedBuilder()
                                .date(forecastExtendedJson.getJSONObject(i).getString("date"))
                                .dayId(days.get(forecastExtendedJson.getJSONObject(i).getString("day")))
                                .description(forecastExtendedJson.getJSONObject(i).getString("text"))
                                .tempMin(forecastExtendedJson.getJSONObject(i).getInt("low"))
                                .tempMax(forecastExtendedJson.getJSONObject(i).getInt("high"))
                                .build());
        }

        w = new WeatherBuilder()
                .description(weatherJson.getString("description"))
                .wind(new WindBuilder()
                        .direction(windJson.getInt("direction"))
                        .speed(windJson.getInt("speed"))
                        .build())
                .atmosphere(new AtmosphereBuilder()
                        .humidity(atmosphereJson.getInt("humidity"))
                        .pressure(atmosphereJson.getDouble("pressure"))
                        .visibility(atmosphereJson.getDouble("visibility"))
                        .rising(atmosphereJson.getInt("rising"))
                        .build())
                .today(new ForecastTodayBuilder()
                        .date(forecastTodayJson.getString("date"))
                        .temp(forecastTodayJson.getInt("temp"))
                        .build())
                .state(new StateBuilder()
                        .name(countryJson.getString("city") )
                        .build())
                .week(forecastExtendedList)
                .build();

        return w;
    }

}
