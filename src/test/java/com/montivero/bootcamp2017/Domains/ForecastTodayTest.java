package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.ForecastTodayBuilder;
import com.montivero.bootcamp2017.utils.DateAdapter;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Daniel on 10/01/2017.
 */
public class ForecastTodayTest {
    private ForecastToday fToday;

    @Test
    public void getTemp(){
        fToday = new ForecastTodayBuilder().temp(30).build();

        assertEquals(30,fToday.getTemp());
    }

    @Test
    public void testForecastTodayTestFromDate() throws ParseException {
        Date dateDate = DateAdapter.dateFormat("20/01/2000");
        fToday = new ForecastTodayBuilder().date(dateDate).build();

        assertEquals(DateAdapter.dateFormat("20/01/2000"),fToday.getDate());
        assertEquals("20/01/2000", fToday.getStringDate());
        assertEquals("2000-01-20", fToday.getSqlDate().toString());
    }

    @Test
    public void testForecastTodayTestFromSqlDate() throws ParseException{

        Date date3 = DateAdapter.dateFormat("20/01/2000");
        java.sql.Date dateSql = DateAdapter.dateSql(date3);
        fToday = new ForecastTodayBuilder()
                .date(dateSql)
                .build();

        assertEquals(DateAdapter.dateFormat("20/01/2000"),fToday.getDate());
        assertEquals("20/01/2000", fToday.getStringDate());
        assertEquals("2000-01-20", fToday.getSqlDate().toString());
    }

    @Test
    public void testForecastTodayTestFromString() throws ParseException{
        String dateString = "20/01/2000";
        fToday = new ForecastTodayBuilder()
                .date(dateString)
                .build();

        assertEquals(DateAdapter.dateFormat("20/01/2000"),fToday.getDate());
        assertEquals("20/01/2000", fToday.getStringDate());
        assertEquals("2000-01-20", fToday.getSqlDate().toString());
    }

}