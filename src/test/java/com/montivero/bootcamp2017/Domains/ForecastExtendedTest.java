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

        assertEquals("Sunday",fExtended.dayToString());
        assertEquals(1,fExtended.getDay());

        fExtended = new ForecastExtendedBuilder().day(6).build();

        assertEquals("Friday",fExtended.dayToString());
        assertEquals(6,fExtended.getDay());

    }

    @Test
    public void getDates() throws ParseException {
        Date date = DateAdapter.dateFormat("20/01/2000");
        fExtended = new ForecastExtendedBuilder().date(date).build();
        assertEquals(DateAdapter.dateFormat("20/01/2000"),fExtended.getDate());
        assertEquals("20/01/2000",fExtended.getStringDate());
        assertEquals("2000-01-20",fExtended.getSqlDate().toString());
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
                fExtended.forecastExtendedToString());
    }

    @Test
    public void testForecastExtended() throws ParseException {
        Date date = DateAdapter.dateFormat("20/01/2000");

        fExtended = new ForecastExtendedBuilder()
                .date(date)
                .day(1)
                .tempMin(20)
                .tempMax(30)
                .description("Cloudy")
                .build();

        System.out.println("Date format: "+fExtended.getDate());
        System.out.println("Date deformat: "+DateAdapter.dateDeformat(fExtended.getDate()));
        System.out.println("Date SqlFormat: "+DateAdapter.dateSql(fExtended.getDate()));
        System.out.println("Day Value: "+fExtended.getDay());
        System.out.println("Day String: "+fExtended.dayToString());
        System.out.println("Temp Min: "+fExtended.getTempMin());
        System.out.println("Temp Max: "+fExtended.getTempMax());
        System.out.println("Description: "+fExtended.getDescription());

        assertEquals(DateAdapter.dateFormat("20/01/2000"),fExtended.getDate());
        assertEquals("20/01/2000",fExtended.getStringDate());
        assertEquals("2000-01-20",fExtended.getSqlDate().toString());
        assertEquals(1,fExtended.getDay());
        assertEquals("Sunday",fExtended.dayToString());
        assertEquals(20,fExtended.getTempMin());
        assertEquals(30,fExtended.getTempMax());
        assertEquals("Cloudy",fExtended.getDescription());

    }

}