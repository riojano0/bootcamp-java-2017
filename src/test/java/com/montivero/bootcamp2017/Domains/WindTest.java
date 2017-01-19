package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.WindBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Daniel on 13/01/2017.
 */
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

    @Test
    public void testToString(){
        wind = new WindBuilder()
                .direction(25)
                .speed(20)
                .build();

        assertEquals("Wind - Speed: 20  Direction: 25",wind.toString());
    }


}