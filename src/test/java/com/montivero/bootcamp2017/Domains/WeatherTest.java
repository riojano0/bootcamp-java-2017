package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.WeatherBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Daniel on 10/01/2017.
 */
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

    @Test
    public void getToString(){
        State mockState = Mockito.mock(State.class);
        ForecastToday mockToday = Mockito.mock(ForecastToday.class);
        Atmosphere mockAtmosphere = Mockito.mock(Atmosphere.class);
        Wind mockWind = Mockito.mock(Wind.class);

        when(mockState.getName()).thenReturn("String of State Name");
        when(mockToday.toString()).thenReturn("String of Today");
        when(mockAtmosphere.toString()).thenReturn("String Atmosphere");
        when(mockWind.toString()).thenReturn("String Wind");

        weather = new WeatherBuilder()
                .state(mockState)
                .today(mockToday)
                .atmosphere(mockAtmosphere)
                .wind(mockWind)
                .description("The description String")
                .build();

        assertEquals("Weather State:\nString of State Name \n\nString of Today \n\nString Atmosphere \n\nString Wind"+
                "\n\nDescription: The description String \n\n ", weather.toString());

    }

    @Test
    public void testWeather() throws Exception{

        /* Country mock */
        Country mockCountry = Mockito.mock(Country.class);
        Mockito.when(mockCountry.getName()).thenReturn("Dummy Country");

        /* State mock */
        State mockState = Mockito.mock(State.class);
        Mockito.when(mockState.getCountry()).thenReturn(mockCountry);

        /* ForecastToday Mock */
        ForecastToday mockForecastToday = Mockito.mock(ForecastToday.class);

        /*  ForecastExtended Mock*/
        ForecastExtended mockForecastExtended = Mockito.mock(ForecastExtended.class);

        /* ForecastExtendedArray */
        ForecastExtended[] weekExtended = {mockForecastExtended,mockForecastExtended,mockForecastExtended,mockForecastExtended,
                mockForecastExtended,mockForecastExtended,mockForecastExtended,mockForecastExtended,mockForecastExtended,mockForecastExtended};

        /* Wind mock */
        Wind mockWind = Mockito.mock(Wind.class);

        /* Atmosphere Mock*/
        Atmosphere mockAtmosphere = Mockito.mock(Atmosphere.class);

        /* Create and Test Weather */
        Weather weather = new WeatherBuilder()
                .state(mockState)
                .today(mockForecastToday)
                .week(weekExtended)
                .wind(mockWind)
                .description("The best Weather")
                .atmosphere(mockAtmosphere)
                .build();

        assertEquals(mockState,weather.getState());
        assertEquals(mockForecastToday,weather.getToday());
        assertArrayEquals(weekExtended,weather.getWeek());
        assertEquals(mockWind,weather.getWind());
        assertEquals(mockAtmosphere,weather.getAtmosphere());
        assertEquals("The best Weather",weather.getDescription());

    }

}