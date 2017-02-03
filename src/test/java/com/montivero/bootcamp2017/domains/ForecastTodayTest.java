package com.montivero.bootcamp2017.domains;


import com.montivero.bootcamp2017.builders.ForecastTodayBuilder;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

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

}