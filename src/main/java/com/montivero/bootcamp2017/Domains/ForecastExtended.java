package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.ForecastExtendedBuilder;
import com.montivero.bootcamp2017.utils.DateAdapter;

import java.util.Date;
import java.util.HashMap;

public class ForecastExtended {

    private Date date;
    private int day;
    private int tempMin;
    private int tempMax;
    private String description;

    private static final HashMap<Integer,String> days;
    static {
        days = new HashMap<Integer,String>();
        days.put(1,"Sunday");
        days.put(2,"Monday");
        days.put(3,"Tuesday");
        days.put(4,"Wednesday");
        days.put(5,"Thursday");
        days.put(6,"Friday");
        days.put(7,"Saturday");
    }

    public ForecastExtended(ForecastExtendedBuilder builder) {

        this.date = builder.date;
        this.day = builder.day;
        this.tempMin = builder.tempMin;
        this.tempMax = builder.tempMax;
        this.description = builder.description;
    }

    public String forecastExtendedToString(){
        return String.format("Forecast Extended: \nDate: %s Day: %s Temp Min: %s°C Temp Max: %s°C Description: %s",
                DateAdapter.dateDeformat(date),
                dayToString(),
                tempMin,
                tempMax,
                description
                );
    }

    public String dayToString(){
        return days.get(day);
    }

    public Date getDate() {
        return date;
    }

    public int getDay() {
        return day;
    }

    public int getTempMin() {
        return tempMin;
    }

    public int getTempMax() {
        return tempMax;
    }

    public String getDescription() {
        return description;
    }

}
