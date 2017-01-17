package com.montivero.bootcamp2017.Builders;

import com.montivero.bootcamp2017.Domains.ForecastToday;
import com.montivero.bootcamp2017.utils.DateAdapter;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Daniel on 14/01/2017.
 */
public class ForecastTodayBuilder {
    public Date date;
    public int temp;

    public ForecastTodayBuilder date(Object date) {
        try{
            if (date instanceof String)
                date = DateAdapter.dateFormat((String) date);
            if (date instanceof java.sql.Date)
                date = DateAdapter.dateFormat((java.sql.Date) date);

            this.date = (Date) date;
            return this;
        }catch (ParseException E){
            System.out.println(E.toString());
            return this;
        }
    }

    public ForecastTodayBuilder temp(int temp){
        this.temp = temp;
        return this;
    }

    public ForecastToday build(){
        return new ForecastToday(this);
    }

}
