package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.ForecastExtendedBuilder;

import java.util.HashMap;

public class ForecastExtended {

    private String date;
    private int dayId;
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

    public ForecastExtended(){};

    public ForecastExtended(ForecastExtendedBuilder builder) {

        this.date = builder.date;
        this.dayId = builder.day;
        this.tempMin = builder.tempMin;
        this.tempMax = builder.tempMax;
        this.description = builder.description;
    }

    @Override
    public String toString(){
        return String.format("Forecast Extended: \nDate: %s Day: %s Temp Min: %s°C Temp Max: %s°C Description: %s",
                date,
                getDayToString(),
                tempMin,
                tempMax,
                description
                );
    }
    public int getDayId() {
        return dayId;
    }

    public String getDayToString(){
        return days.get(dayId);
    }

    public String getDate() {
        return date;
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
