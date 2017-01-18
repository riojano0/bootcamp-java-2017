package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.AtmosphereBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Daniel on 09/01/2017.
 */
public class AtmosphereTest {
    private Atmosphere atmosphere;

    @Test
    public void getHumidity(){
        atmosphere = new AtmosphereBuilder().humidity(10).build();
        assertEquals(10, atmosphere.getHumidity());
    }

    @Test
    public void getPressure(){
        atmosphere = new AtmosphereBuilder().pressure(20.2).build();
        assertEquals(20.2, atmosphere.getPressure(),2);
    }

    @Test
    public void getVisibility(){
        atmosphere = new AtmosphereBuilder().visibility(200).build();
        assertEquals(200, atmosphere.getVisibility(),0);
    }

    @Test
    public void getRising(){
        atmosphere = new AtmosphereBuilder().rising(15).build();
        assertEquals(15, atmosphere.getRising());
    }

    @Test public void getToString(){
        atmosphere = new AtmosphereBuilder()
                .humidity(10)
                .pressure(20.2)
                .visibility(200)
                .rising(15)
                .build();

        assertEquals("Atmosphere: \nHumidity: 10 \nPressure: 20.2 \nVisibility: 200.0 \nRising: 15",
                atmosphere.atmosphereToString());
    }

    @Test
    public void testAtmosphere() {
        /* Case of Atmosphere */
        atmosphere = new AtmosphereBuilder()
                .humidity(10)
                .pressure(20.2)
                .visibility(200)
                .rising(15)
                .build();

        assertEquals(10, atmosphere.getHumidity());
        assertEquals(20.2, atmosphere.getPressure(),2);
        assertEquals(200, atmosphere.getVisibility(),0);
        assertEquals(15, atmosphere.getRising());

    }

}