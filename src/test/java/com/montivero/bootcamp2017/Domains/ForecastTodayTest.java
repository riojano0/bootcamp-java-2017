package com.montivero.bootcamp2017.Domains;

import org.junit.Test;
import com.montivero.bootcamp2017.utils.DateAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 10/01/2017.
 */
public class ForecastTodayTest {

    @Test
    public void testForecastTodayTest() throws ParseException {
        Date date = DateAdapter.dateFormat("20/01/2000");
        ForecastToday fToday = new ForecastToday(date,35);
        System.out.println("Date format: "+fToday.getDate());
        System.out.println("Date deformat: "+DateAdapter.dateDeformat(fToday.getDate()));
        System.out.println("Date SqlFormat: "+DateAdapter.dateSql(fToday.getDate()));
        System.out.println("Temp: "+fToday.getTemp());

        assertEquals(DateAdapter.dateFormat("20/01/2000"),fToday.getDate());
        assertEquals("20/01/2000",DateAdapter.dateDeformat(fToday.getDate()));
        assertEquals(DateAdapter.dateFormat("20/01/2000"),DateAdapter.dateSql(fToday.getDate()));
        assertEquals(35,fToday.getTemp());

    }

}