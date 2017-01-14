package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.*;
import org.junit.Test;
import com.montivero.bootcamp2017.utils.DateAdapter;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 10/01/2017.
 */
public class WeatherTest {

    @Test
    public void testWeather() throws Exception{

        /* Country Dummy */
        Country dummyCountry = new CountryBuilder().name("Dummy-Country")
                .shortName2("dc")
                .shortName3("dmc")
                .build();

        /* State Dummy */
        State dummyState = new StateBuilder()
                .country(dummyCountry)
                .name("Dummy-State")
                .shortName("DumS")
                .area(100)
                .capital("Dummy-Capital")
                .build();


        /* Date for ForecastToday */
        Date dateToday = new Date();

        /* Case of ForecastToday */
        ForecastToday today = new ForecastTodayBuilder().date(dateToday).temp(45).build();

        /*  Dates for ForecastExtended */
        Date day01date = DateAdapter.dateFormat("21/06/2016");
        Date day02date = DateAdapter.dateFormat("21/06/2016");
        Date day03date = DateAdapter.dateFormat("21/06/2016");
        Date day04date = DateAdapter.dateFormat("21/06/2016");
        Date day05date = DateAdapter.dateFormat("21/06/2016");
        Date day06date = DateAdapter.dateFormat("21/06/2016");
        Date day07date = DateAdapter.dateFormat("21/06/2016");
        Date day08date = DateAdapter.dateFormat("21/06/2016");
        Date day09date = DateAdapter.dateFormat("21/06/2016");
        Date day10date = DateAdapter.dateFormat("21/06/2016");

        /*  Cases of ForecastExtended */
        ForecastExtended day01 = new ForecastExtended(day01date, 1, 20, 30, "Cloudy");
        ForecastExtended day02 = new ForecastExtended(day02date, 2, 20, 30, "Cloudy");
        ForecastExtended day03 = new ForecastExtended(day03date, 3, 20, 30, "Cloudy");
        ForecastExtended day04 = new ForecastExtended(day04date, 4, 20, 30, "Cloudy");
        ForecastExtended day05 = new ForecastExtended(day05date, 5, 20, 30, "Cloudy");
        ForecastExtended day06 = new ForecastExtended(day06date, 6, 20, 30, "Cloudy");
        ForecastExtended day07 = new ForecastExtended(day07date, 7, 20, 30, "Cloudy");
        ForecastExtended day08 = new ForecastExtended(day08date, 1, 20, 30, "Cloudy");
        ForecastExtended day09 = new ForecastExtended(day09date, 2, 20, 30, "Cloudy");
        ForecastExtended day10 = new ForecastExtended(day10date, 3, 20, 30, "Cloudy");

        /* Array of ForecastExtendes */
        ForecastExtended[] weekExtended = {day01,day02,day03,day04,day05,day06,day07,day08,day09,day10};

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

        Weather Weather = new Weather(dummyState,today,weekExtended,wind,atmosphere,"The best Weather");
        System.out.println("State: "+Weather.getState().getName());
        System.out.println(String.format("Weather now: %s Temperature %s°C",Weather.getToday().getDate(),Weather.getToday().getTemp()));
        System.out.println(String.format("Wind : Speed:%s Direction:%s",Weather.getWind().getSpeed(),Weather.getWind().getDirection()));
        System.out.println(String.format("Atmosphere : Humidity:%s Pressure:%s Rising:%s Visibility:%s",
                Weather.getAtmosphere().getHumidity(),
                Weather.getAtmosphere().getPressure(),
                Weather.getAtmosphere().getRising(),
                Weather.getAtmosphere().getVisibility()));
        for (int i = 0; i<=9;i++){
            System.out.println(String.format("Extended Forecast Date %s, Day %s, Min %s, Max %s, Description %s ",
                    Weather.getWeek()[i].getDate(),
                    Weather.getWeek()[i].dayToString(),
                    Weather.getWeek()[i].getTempMin(),
                    Weather.getWeek()[i].getTempMax(),
                    Weather.getWeek()[i].getDescription()));
        }

        assertEquals(dummyState,Weather.getState());
        assertEquals(today,Weather.getToday());
        assertArrayEquals(weekExtended,Weather.getWeek());
        assertEquals(wind,Weather.getWind());
        assertEquals(atmosphere,Weather.getAtmosphere());
        assertEquals("The best Weather",Weather.getDescription());

    }

}