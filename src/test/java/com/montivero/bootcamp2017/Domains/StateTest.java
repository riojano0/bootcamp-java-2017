package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.StateBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Daniel on 09/01/2017.
 */
public class StateTest {

    private Country mockCountry;
    private State testState;

    @Test
    public void getCountry(){
        mockCountry = Mockito.mock(Country.class);
        Mockito.when(mockCountry.getName()).thenReturn("Dummy Country");

        testState = new StateBuilder().country(mockCountry).build();
        assertEquals("Dummy Country", testState.getCountry().getName());
    }

    @Test
    public void getName(){
        testState = new StateBuilder().name("dummy state").build();
        assertEquals("Dummy State", testState.getName());
        assertNotEquals("dummy state", testState.getName());
    }

    @Test
    public void getShortName(){
        testState = new StateBuilder().shortName("dums").build();
        assertEquals("DUMS", testState.getShortName());
    }

    @Test
    public void getArea(){
        testState = new StateBuilder().area(100.50).build();
        assertEquals(100.50, testState.getArea(),0);
    }

    @Test
    public void getCapital(){
        testState = new StateBuilder().capital("dummy caPitAl").build();
        assertEquals("Dummy Capital", testState.getCapital());
    }

    @Test
    public void testState(){
        /* Country Mockito */
        mockCountry = Mockito.mock(Country.class);
        Mockito.when(mockCountry.getName()).thenReturn("Dummy Country");

        /* State Dummy */
        State dummyState = new StateBuilder()
                .country(mockCountry)
                .name("Dummy state")
                .shortName("DumS")
                .area(100.50)
                .capital("Dummy Capital")
                .build();

        assertEquals(mockCountry,dummyState.getCountry());
        assertEquals("Dummy State",dummyState.getName());
        assertEquals("DUMS",dummyState.getShortName());
        assertEquals(100.50,dummyState.getArea(),0);
        assertEquals("Dummy Capital",dummyState.getCapital());

    }

}