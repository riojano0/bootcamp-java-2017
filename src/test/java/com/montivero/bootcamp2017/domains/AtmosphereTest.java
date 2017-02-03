package com.montivero.bootcamp2017.domains;

import com.montivero.bootcamp2017.builders.AtmosphereBuilder;
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


}