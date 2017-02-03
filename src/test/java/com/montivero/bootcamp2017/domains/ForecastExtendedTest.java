package com.montivero.bootcamp2017.domains;


import com.montivero.bootcamp2017.builders.ForecastExtendedBuilder;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;



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
    public void getDates() throws ParseException {

        fExtended = new ForecastExtendedBuilder().date("21/12/2018").build();
        assertEquals("21/12/2018",fExtended.getDate());

    }

}