package com.montivero.bootcamp2017.services;

import com.montivero.bootcamp2017.domains.ForecastExtended;
import com.montivero.bootcamp2017.domains.Weather;
import com.montivero.bootcamp2017.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherProxy {

    @Autowired
    private WeatherAdapter weatherAdapter;
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

    public Weather getWeather(String countryName, String stateName){
        if (weatherAdapter.getWeather(countryName, stateName) != null) {
            return weatherAdapter.getWeather(countryName, stateName);
        } else {
            return weatherRepository.findByStateName(stateName);
        }
    }

    public String save(Weather weather){
        try {
            if (windRepository.findBySpeedAndDirection(weather.getWind().getSpeed(), weather.getWind().getDirection()).isEmpty())
                windRepository.save(weather.getWind());

            weather.setWind(windRepository.findBySpeedAndDirection(weather.getWind().getSpeed(), weather.getWind().getDirection()).get(0));

            if (atmosphereRepository.findByHumidityAndPressureAndRisingAndVisibility(
                    weather.getAtmosphere().getHumidity(), weather.getAtmosphere().getPressure(),
                    weather.getAtmosphere().getRising(), weather.getAtmosphere().getVisibility()).isEmpty())
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

            List<ForecastExtended> tempWeek = new ArrayList<ForecastExtended>();
            for (ForecastExtended f : weather.getWeek()) {
                if (forecastExtendedRepository.findByDateAndDescriptionAndTempMaxAndTempMin(
                        f.getDate(), f.getDescription(), f.getTempMax(), f.getTempMin()).isEmpty()) {
                    forecastExtendedRepository.save(f);
                }
                tempWeek.add(forecastExtendedRepository.findByDateAndDescriptionAndTempMaxAndTempMin(
                        f.getDate(), f.getDescription(), f.getTempMax(), f.getTempMin()).get(0));
            }
            weather.setWeek(tempWeek);

            weatherRepository.save(weather);
            return "Added";
        } catch (Exception e){
            return "Save Failed";
        }
    }

}
