package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.ForecastExtendedBuilder;
import org.junit.Test;
import com.montivero.bootcamp2017.utils.DateAdapter;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 10/01/2017.
 */
public class ForecastExtendedTest {

    @Test
    public void testForecastExtended() throws ParseException {
        Date date = DateAdapter.dateFormat("20/01/2000");

        ForecastExtended fExtended = new ForecastExtendedBuilder()
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
        assertEquals("20/01/2000",DateAdapter.dateDeformat(fExtended.getDate()));
        assertEquals(DateAdapter.dateFormat("20/01/2000"),DateAdapter.dateSql(fExtended.getDate()));
        assertEquals(1,fExtended.getDay());
        assertEquals("Sunday",fExtended.dayToString());
        assertEquals(20,fExtended.getTempMin());
        assertEquals(30,fExtended.getTempMax());
        assertEquals("Cloudy",fExtended.getDescription());

    }

}