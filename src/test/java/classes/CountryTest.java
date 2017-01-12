package classes;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 09/01/2017.
 */
public class CountryTest {

    @Test
    public void testCountry(){
        /* Country Dummy */
        Country dummyCountry = new Country("Dummmy-Country","dc","dmc");

        System.out.println(String.format("Country Name: %s",dummyCountry.getName()));
        System.out.println(String.format("Country: %s",dummyCountry.getShort_name_2()));
        System.out.println(String.format("State short name: %s",dummyCountry.getShort_name_3()));

        assertEquals("Dummmy-Country",dummyCountry.getName());
        assertEquals("DC",dummyCountry.getShort_name_2());
        assertEquals("DMC",dummyCountry.getShort_name_3());

    }

}