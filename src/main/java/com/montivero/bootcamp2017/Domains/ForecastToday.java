package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.ForecastTodayBuilder;
import com.montivero.bootcamp2017.utils.DateAdapter;

import java.util.Date;

public class ForecastToday {
    private String date;
    private int temp;

    public ForecastToday(){};

    public ForecastToday(ForecastTodayBuilder builder) {
        this.date = builder.date;
        this.temp = builder.temp;
    }

    @Override
    public String toString(){
        return String.format("Forecast Today: \nDate: %s \nTemp: %s°C", date,temp);
    }

    public String getDate() {
        return date;
    }

    public int getTemp() {
        return temp;
    }

}
