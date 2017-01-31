package com.montivero.bootcamp2017.controllers;

import com.montivero.bootcamp2017.domains.ForecastExtended;
import com.montivero.bootcamp2017.domains.Weather;
import com.montivero.bootcamp2017.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@Path("/weather")
public class WeatherController{

    @Autowired
    private AtmosphereRepository atmosphereRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ForecastExtendedRepository forecastExtendedRepository;
    @Autowired
    private ForecastTodayRepository forecastTodayRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private WindRepository windRepository;
    @Autowired
    private WeatherRepository weatherRepository;

    @GET
    @Path("/")
    @Produces("application/json")
    public List<Weather> getAllWeather(){
        return weatherRepository.findAll();
    }

    @GET
    @Path("/get/state/{name}")
    @Produces("application/json")
    public List<Object> getWeatherForName(@PathParam("name") String name,@QueryParam("date") String date){
        List<Object> outList= new ArrayList<Object>();
        if (date==null)
            outList.add(weatherRepository.findByStateName(name));
        else{
            Weather w = weatherRepository.findByStateNameAndWeekDate(name,date);
            outList.add(w.getState());
            for (ForecastExtended f : w.getWeek())
                if (f.getDate().equals(date))
                    outList.add(f);
        }
        return outList;
    }

    @POST
    @Path("/saveWeather")
    @Produces("application/json")
    @Consumes("application/json")
    public String saveWeather(Weather weather){
        try {
            if (windRepository.findBySpeedAndDirection(weather.getWind().getSpeed(), weather.getWind().getDirection()).isEmpty())
                windRepository.save(weather.getWind());

            weather.setWind(windRepository.findBySpeedAndDirection(weather.getWind().getSpeed(), weather.getWind().getDirection()).get(0));

            if (atmosphereRepository.findByHumidityAndPressureAndRisingAndVisibility(
                    weather.getAtmosphere().getHumidity(), weather.getAtmosphere().getPressure(),
                    weather.getAtmosphere().getRising(), weather.getAtmosphere().getVisibility()) == null)
                atmosphereRepository.save(weather.getAtmosphere());

            weather.setAtmosphere(atmosphereRepository.findByHumidityAndPressureAndRisingAndVisibility(
                    weather.getAtmosphere().getHumidity(), weather.getAtmosphere().getPressure(),
                    weather.getAtmosphere().getRising(), weather.getAtmosphere().getVisibility()).get(0));

            if (countryRepository.findByName(weather.getState().getCountry().getName()) == null)
                countryRepository.save(weather.getState().getCountry());

            weather.getState().setCountry(countryRepository.findByName(weather.getState().getCountry().getName()));

            if (stateRepository.findByNameAndCountryName(weather.getState().getName(),
                    weather.getState().getCountry().getName()).isEmpty())
                stateRepository.save(weather.getState());

            weather.setState(stateRepository.findByNameAndCountryName(weather.getState().getName(),
                    weather.getState().getCountry().getName()).get(0));

            if (forecastTodayRepository.findByDateAndTemp(weather.getToday().getDate(), weather.getToday().getTemp()).isEmpty())
                forecastTodayRepository.save(weather.getToday());

            weather.setToday(forecastTodayRepository.findByDateAndTemp(weather.getToday().getDate(), weather.getToday().getTemp()).get(0));

            List<ForecastExtended> temp = new ArrayList<ForecastExtended>();
            for (ForecastExtended f : weather.getWeek()) {
                if (forecastExtendedRepository.findByDateAndDescriptionAndTempMaxAndTempMin(
                        f.getDate(), f.getDescription(), f.getTempMax(), f.getTempMin()).isEmpty()) {
                    forecastExtendedRepository.save(f);
                }
                temp.add(forecastExtendedRepository.findByDateAndDescriptionAndTempMaxAndTempMin(
                        f.getDate(), f.getDescription(), f.getTempMax(), f.getTempMin()).get(0));
            }
            weather.setWeek(temp);

            weatherRepository.save(weather);
            return "Added";
        }
        catch (Exception E){
            return "Save Failed";
        }

    }


}
