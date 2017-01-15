package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.WindBuilder;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

/**
 * Created by Daniel on 13/01/2017.
 */
public class WindTest {

    Logger l = Logger.getLogger("Class Wind");
    @Test
    public void getSpeed() throws Exception {
//        Wind w =  new Wind(1,2);
        Wind w = new WindBuilder().speed(1).direction(2).build();
        l.info("Test: getSpeed() ");
        assertEquals(1, w.getSpeed());
    }

//    @Test
//    public void setSpeed() throws Exception {
//        Wind w = new WindBuilder().speed(1).direction(2).build();
//        w.setSpeed(3);
//        l.info("Test: setSpeed()");
//        assertEquals(3, w.getSpeed());
//    }

    @Test
    public void getDirection() throws Exception {
        Wind w = new WindBuilder().speed(1).direction(2).build();
        l.info("Test: getDirection()");
        assertEquals(2, w.getDirection());
    }

//    @Test
//    public void setDirection() throws Exception {
//        Wind w = new WindBuilder().speed(1).direction(2).build();
//        w.setDirection(4);
//        l.info("Test: setDirection()");
//        assertEquals(4, w.getDirection());
//
//    }

    @Test
    public void testWind() throws Exception{
        Wind w = new WindBuilder()
                .direction(25)
                .speed(20)
                .build();
        Logger l = Logger.getLogger(Wind.class.getName());
        l.info("Test wind class");
        l.info("Speed: "+w.getSpeed());
        l.info("Direction: "+w.getDirection());
        assertEquals(20,w.getSpeed());
        assertEquals(25,w.getDirection());

    }


}