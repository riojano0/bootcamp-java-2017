package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.CountryBuilder;
import com.montivero.bootcamp2017.Builders.StateBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Daniel on 09/01/2017.
 */
public class StateTest {

    @Test
    public void testState(){
        /* Country Dummy */
        Country dummyCountry = new CountryBuilder().name("dUMMy country")
                .shortName2("dc")
                .shortName3("dmc")
                .build();

        /* State Dummy */
        State dummyState = new StateBuilder()
                .country(dummyCountry)
                .name("Dummy state")
                .shortName("DumS")
                .area(100.50)
                .capital("Dummy Capital")
                .build();

        System.out.println(String.format("State: %s",dummyState.getName()));
        System.out.println(String.format("Country: %s",dummyState.getCountry().getName()));
        System.out.println(String.format("State short name: %s",dummyState.getShort_name()));
        System.out.println(String.format("Area: %s",dummyState.getArea()));
        System.out.println(String.format("Capital: %s",dummyState.getCapital()));

        assertEquals(dummyCountry,dummyState.getCountry());
        assertEquals("Dummy State",dummyState.getName());
        assertEquals("DUMS",dummyState.getShort_name());
        assertEquals(100.50,dummyState.getArea(),0);
        assertEquals("Dummy Capital",dummyState.getCapital());

    }

}