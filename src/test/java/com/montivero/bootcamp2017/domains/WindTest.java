package com.montivero.bootcamp2017.domains;

import com.montivero.bootcamp2017.builders.WindBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WindTest {

    private Wind wind;

    @Test
    public void getSpeed() throws Exception {
        wind = new WindBuilder().speed(1).build();
        assertEquals(1, wind.getSpeed());

    }

    @Test
    public void getDirection() throws Exception {
        wind= new WindBuilder().direction(2).build();
        assertEquals(2, wind.getDirection());
    }

    @Test
    public void testWind() throws Exception{
        wind = new WindBuilder()
                .direction(25)
                .speed(20)
                .build();
        assertEquals(20,wind.getSpeed());
        assertEquals(25,wind.getDirection());
    }

}