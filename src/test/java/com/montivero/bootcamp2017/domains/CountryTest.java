package com.montivero.bootcamp2017.domains;

import com.montivero.bootcamp2017.builders.CountryBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Daniel on 09/01/2017.
 */
public class CountryTest {

    private Country dummyCountry;

    @Before
    public void initialize(){
        dummyCountry=null;
    }

    @Test
    public void testCountry(){
        dummyCountry = new CountryBuilder().build();

        assertEquals("Dummy Country",dummyCountry.getName());
        assertEquals("DC",dummyCountry.getShortName2());
        assertEquals("DMC",dummyCountry.getShortName3());

    }


    @Test
    public void getName(){
        dummyCountry = new CountryBuilder()
                .name("other country")
                .build();

        assertEquals("other country",dummyCountry.getName());
    }

    @Test
    public void getShortName2(){
        dummyCountry = new CountryBuilder()
                .shortName2("dc")
                .build();

        assertEquals("DC",dummyCountry.getShortName2());

    }

    @Test
    public void getShortName3(){
        dummyCountry = new CountryBuilder()
                .shortName3("dmc")
                .build();

        assertEquals("DMC",dummyCountry.getShortName3());


    }

}