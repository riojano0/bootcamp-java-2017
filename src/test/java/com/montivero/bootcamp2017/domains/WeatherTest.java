package com.montivero.bootcamp2017.domains;

import com.montivero.bootcamp2017.builders.WeatherBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class WeatherTest {

    private Weather weather;

    @Test
    public void getState(){
        State mockState = Mockito.mock(State.class);

        when(mockState.getName()).thenReturn("Mock State");

        weather = new WeatherBuilder().state(mockState).build();

        assertEquals(mockState,weather.getState());
        assertEquals("Mock State",weather.getState().getName());

    }

    @Test
    public void getWeatherToday(){
        ForecastToday mockToday = Mockito.mock(ForecastToday.class);

        when(mockToday.getTemp()).thenReturn(35);

        weather = new WeatherBuilder().today(mockToday).build();

        assertEquals(mockToday,weather.getToday());
        assertEquals(35,weather.getToday().getTemp());

    }


    @Test
    public void getWind(){
        Wind mockWind = Mockito.mock(Wind.class);
        weather = new WeatherBuilder().wind(mockWind).build();

        assertEquals(mockWind,weather.getWind());

    }

    @Test
    public void getAtmosphere(){
        Atmosphere mockAtmosphere = Mockito.mock(Atmosphere.class);

        weather = new WeatherBuilder().atmosphere(mockAtmosphere).build();
        assertEquals(mockAtmosphere,weather.getAtmosphere());
    }

    @Test
    public void getDescription(){
        weather = new WeatherBuilder().description("The best description").build();

        assertEquals("The best description",weather.getDescription());

    }




}