package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.ForecastTodayBuilder;
import com.montivero.bootcamp2017.utils.DateAdapter;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Daniel on 10/01/2017.
 */
public class ForecastTodayTest {
    private ForecastToday fToday;

    @Test
    public void getTemp(){
        fToday = new ForecastTodayBuilder().temp(30).build();

        assertEquals(30,fToday.getTemp());
    }

    @Test
    public void testForecastTodayTestGetDate() throws ParseException {

        fToday = new ForecastTodayBuilder().date("20/01/2000").build();

        assertEquals("20/01/2000", fToday.getDate());

    }


    @Test
    public void ForecastTodayToString() throws ParseException{
        fToday = new ForecastTodayBuilder().build();

        String expect = "Forecast Today: \nDate: 17/06/2017 \nTemp: 45°C";

        assertEquals(expect,fToday.toString());
    }

}