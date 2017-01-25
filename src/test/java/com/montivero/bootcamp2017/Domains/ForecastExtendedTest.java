package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.ForecastExtendedBuilder;
import com.montivero.bootcamp2017.utils.DateAdapter;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Daniel on 10/01/2017.
 */
public class ForecastExtendedTest {

    private ForecastExtended fExtended;

    @Test
    public void getDescription(){
        fExtended = new ForecastExtendedBuilder().description("Cloudy").build();
        assertEquals("Cloudy", fExtended.getDescription());
    }

    @Test
    public void getMaxTemp(){
        fExtended = new ForecastExtendedBuilder().tempMax(45).build();
        assertEquals(45,fExtended.getTempMax());
    }

    @Test
    public void getMinTemp(){
        fExtended = new ForecastExtendedBuilder().tempMin(-15).build();
        assertEquals(-15,fExtended.getTempMin());
    }

    @Test
    public void getDay(){
        fExtended = new ForecastExtendedBuilder().day(1).build();

        assertEquals("Sunday",fExtended.getDayToString());
        assertEquals(1,fExtended.getDayId());

        fExtended = new ForecastExtendedBuilder().day(6).build();

        assertEquals("Friday",fExtended.getDayToString());
        assertEquals(6,fExtended.getDayId());

    }

    @Test
    public void getDates() throws ParseException {

        fExtended = new ForecastExtendedBuilder().date("21/12/2018").build();
        assertEquals("21/12/2018",fExtended.getDate());

    }

    @Test
    public void getToString() throws ParseException {
        fExtended = new ForecastExtendedBuilder()
                .date("20/01/2018")
                .day(1)
                .tempMin(20)
                .tempMax(30)
                .description("Cloudy")
                .build();

        assertEquals("Forecast Extended: \nDate: 20/01/2018 Day: Sunday Temp Min: 20°C Temp Max: 30°C Description: Cloudy",
                fExtended.toString());
    }

    @Test
    public void testForecastExtended() throws ParseException {

        fExtended = new ForecastExtendedBuilder()
                .date("20/01/2000")
                .day(1)
                .tempMin(20)
                .tempMax(30)
                .description("Cloudy")
                .build();

        System.out.println("Date format: "+fExtended.getDate());
        System.out.println("Day Value: "+fExtended.getDayId());
        System.out.println("Day String: "+fExtended.getDayToString());
        System.out.println("Temp Min: "+fExtended.getTempMin());
        System.out.println("Temp Max: "+fExtended.getTempMax());
        System.out.println("Description: "+fExtended.getDescription());


        assertEquals("20/01/2000",fExtended.getDate());
        assertEquals(1,fExtended.getDayId());
        assertEquals("Sunday",fExtended.getDayToString());
        assertEquals(20,fExtended.getTempMin());
        assertEquals(30,fExtended.getTempMax());
        assertEquals("Cloudy",fExtended.getDescription());

    }

}