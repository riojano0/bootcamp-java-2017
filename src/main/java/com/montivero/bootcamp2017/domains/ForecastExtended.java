package com.montivero.bootcamp2017.domains;

import com.montivero.bootcamp2017.builders.ForecastExtendedBuilder;

import javax.persistence.*;
import java.util.HashMap;

@Entity
@Table(name="forecast_extended")
public class ForecastExtended {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

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

    public ForecastExtended(String date, int dayId, int tempMin, int tempMax, String description) {
        this.date = date;
        this.dayId = dayId;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.description = description;
    }

    public ForecastExtended(ForecastExtendedBuilder builder){
        this.date = builder.date;
        this.dayId = builder.dayId;
        this.tempMin = builder.tempMin;
        this.tempMax = builder.tempMax;
        this.description = builder.description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public String getDateString() {
        return days.get(dayId);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
