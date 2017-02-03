package com.montivero.bootcamp2017.controllers;

import com.montivero.bootcamp2017.domains.Weather;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 02/02/2017.
 */
public class WeatherControllerTest {
    @Test
    public void getWeather() throws Exception {

        WeatherController weatherController = Mockito.mock(WeatherController.class);
        Weather weather = Mockito.mock(Weather.class);

        Mockito.when(weatherController.getWeather("IND","Assadim")).thenReturn(weather);
        assertEquals(weather,weatherController.getWeather("IND","Assadim"));

    }

}