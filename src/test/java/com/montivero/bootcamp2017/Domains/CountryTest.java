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
        System.out.println(String.format("Country: %s",dummyCountry.getShort_name_2()));
        System.out.println(String.format("State short name: %s",dummyCountry.getShort_name_3()));

        assertEquals("Dummy-Country",dummyCountry.getName());
        assertEquals("DC",dummyCountry.getShort_name_2());
        assertEquals("DMC",dummyCountry.getShort_name_3());

    }

}