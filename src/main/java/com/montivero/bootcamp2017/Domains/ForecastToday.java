package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.ForecastTodayBuilder;
import com.montivero.bootcamp2017.utils.DateAdapter;

import java.util.Date;

public class ForecastToday {
    private Date date;
    private int temp;

    public ForecastToday(ForecastTodayBuilder builder) {
        this.date = builder.date;
        this.temp = builder.temp;
    }

    public String forecastTodayToString(){
        return String.format("Forecast Today: \nDate: %s \nTemp: %s°C", DateAdapter.dateDeformat(date),temp);
    }

    public Date getDate() {
        return date;
    }

    public java.sql.Date getSqlDate(){ return DateAdapter.dateSql(date);}

    public String getStringDate(){ return DateAdapter.dateDeformat(date);}

    public int getTemp() {
        return temp;
    }

}
