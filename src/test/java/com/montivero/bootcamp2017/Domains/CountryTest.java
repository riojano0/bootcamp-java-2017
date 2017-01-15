package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.CountryBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 09/01/2017.
 */
public class CountryTest {

    @Test
    public void testCountry(){
        /* Country Dummy */
        Country dummyCountry = new CountryBuilder().name("Dummy-Country")
                                                    .shortName2("dc")
                                                    .shortName3("dmc")
                                                    .build();

        System.out.println(String.format("Country Name: %s",dummyCountry.getName()));
        System.out.println(String.format("Country: %s",dummyCountry.getShortName2()));
        System.out.println(String.format("State short name: %s",dummyCountry.getShortName3()));

        assertEquals("Dummy-Country",dummyCountry.getName());
        assertEquals("DC",dummyCountry.getShortName2());
        assertEquals("DMC",dummyCountry.getShortName3());

    }

    @Test
    public void getName(){
        Country dummyCountry = new CountryBuilder()
                .name("Dummy-Country")
                .build();

        assertEquals("Dummy-Country",dummyCountry.getName());
        assertNull(dummyCountry.getShortName2());
        assertNull(dummyCountry.getShortName3());

    }

    @Test
    public void getShortName2(){
        Country dummyCountry = new CountryBuilder()
                .shortName2("dc")
                .build();

        assertEquals("DC",dummyCountry.getShortName2());
        assertNull(dummyCountry.getName());
        assertNull(dummyCountry.getShortName3());

    }

    @Test
    public void getShortName3(){
        Country dummyCountry = new CountryBuilder()
                .shortName3("dmc")
                .build();

        assertEquals("DMC",dummyCountry.getShortName3());
        assertNull(dummyCountry.getName());
        assertNull(dummyCountry.getShortName2());

    }

}