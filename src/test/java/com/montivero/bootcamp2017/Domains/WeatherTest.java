package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.*;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Daniel on 10/01/2017.
 */
public class WeatherTest {

    @Test
    public void testWeather() throws Exception{

        /* Country Dummy */
        Country dummyCountry = new CountryBuilder().name("Dummy country")
                .shortName2("dc")
                .shortName3("dmc")
                .build();

        /* State Dummy */
        State dummyState = new StateBuilder()
                .country(dummyCountry)
                .name("Dummy State")
                .shortName("DumS")
                .area(100)
                .capital("Dummy Capital")
                .build();

        /* Date for ForecastToday */
        Date dateToday = new Date();

        /* Case of ForecastToday */
        ForecastToday today = new ForecastTodayBuilder().date(dateToday).temp(45).build();

        /*  Cases of ForecastExtended */
        ForecastExtended fExtendedDay01 = new ForecastExtendedBuilder()
                .date("21/06/2016").day(1).tempMin(20).tempMax(30).description("Cloudy").build();
        ForecastExtended fExtendedDay02 = new ForecastExtendedBuilder()
                .date("22/06/2016").day(2).tempMin(20).tempMax(35).description("Not Cloudy").build();
        ForecastExtended fExtendedDay03 = new ForecastExtendedBuilder()
                .date("23/06/2016").day(3).tempMin(20).tempMax(40).description("Cloudy").build();
        ForecastExtended fExtendedDay04 = new ForecastExtendedBuilder()
                .date("24/06/2016").day(4).tempMin(20).tempMax(41).description("Cloudy").build();
        ForecastExtended fExtendedDay05 = new ForecastExtendedBuilder()
                .date("25/06/2016").day(5).tempMin(20).tempMax(42).description("Cloudy").build();
        ForecastExtended fExtendedDay06 = new ForecastExtendedBuilder()
                .date("26/06/2016").day(6).tempMin(20).tempMax(43).description("Cloudy").build();
        ForecastExtended fExtendedDay07 = new ForecastExtendedBuilder()
                .date("27/06/2016").day(7).tempMin(20).tempMax(44).description("Cloudy").build();
        ForecastExtended fExtendedDay08 = new ForecastExtendedBuilder()
                .date("28/06/2016").day(1).tempMin(20).tempMax(45).description("Cloudy").build();
        ForecastExtended fExtendedDay09 = new ForecastExtendedBuilder()
                .date("29/06/2016").day(2).tempMin(20).tempMax(46).description("Cloudy").build();
        ForecastExtended fExtendedDay10 = new ForecastExtendedBuilder()
                .date("30/06/2016").day(3).tempMin(20).tempMax(47).description("The hell").build();

        /* Array of ForecastExtendes */
        ForecastExtended[] weekExtended = {fExtendedDay01,fExtendedDay02,fExtendedDay03,fExtendedDay04,
                fExtendedDay05,fExtendedDay06,fExtendedDay07,fExtendedDay08,fExtendedDay09,fExtendedDay10};

        /* Case of Wind */
        Wind wind = new WindBuilder().speed(20).direction(15).build();;

        /* Case of Atmosphere */
        Atmosphere atmosphere = new AtmosphereBuilder()
                .humidity(10)
                .pressure(20.2)
                .visibility(200)
                .rising(15)
                .build();

        /* Create and Test Weather */
        Weather weather = new WeatherBuilder()
                .state(dummyState)
                .today(today)
                .week(weekExtended)
                .wind(wind)
                .description("The best Weather")
                .atmosphere(atmosphere)
                .build();

        System.out.println(weather.weatherToString());

        assertEquals(dummyState,weather.getState());
        assertEquals(today,weather.getToday());
        assertArrayEquals(weekExtended,weather.getWeek());
        assertEquals(wind,weather.getWind());
        assertEquals(atmosphere,weather.getAtmosphere());
        assertEquals("The best Weather",weather.getDescription());

    }

}