package classes;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 09/01/2017.
 */
public class WindTest {
    Logger l = Logger.getLogger("Class Wind");
    @Test
    public void getSpeed() throws Exception {
        Wind w =  new Wind(1,2);
        l.info("Test: getSpeed() ");
        assertEquals(1, w.getSpeed());
    }

    @Test
    public void setSpeed() throws Exception {
        Wind w =  new Wind(1,2);
        w.setSpeed(3);
        l.info("Test: setSpeed()");
        assertEquals(3, w.getSpeed());
    }

    @Test
    public void getDirection() throws Exception {
        Wind w =  new Wind(1,2);
        l.info("Test: getDirection()");
        assertEquals(2, w.getDirection());
    }

    @Test
    public void setDirection() throws Exception {
        Wind w =  new Wind(1,2);
        w.setDirection(4);
        l.info("Test: setDirection()");
        assertEquals(4, w.getDirection());

    }

    @Test
    public void testWind() throws Exception{
        Wind w =  new Wind(20,25);
        Logger l = Logger.getLogger(Wind.class.getName());
        l.info("Test wind class");
        l.info("Speed: "+w.getSpeed());
        l.info("Direction: "+w.getDirection());
        assertEquals(20,w.getSpeed());
        assertEquals(25,w.getDirection());

    }

}