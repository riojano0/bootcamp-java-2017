package com.montivero.bootcamp2017.domains;

import com.montivero.bootcamp2017.builders.ForecastTodayBuilder;

import javax.persistence.*;

@Entity
@Table(name="forecast_today")
public class ForecastToday {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private int temp;

    public ForecastToday(){};

    public ForecastToday(String date, int temp) {
        this.date = date;
        this.temp = temp;
    }

    public ForecastToday(ForecastTodayBuilder builder) {
        this.date = builder.date;
        this.temp = builder.temp;
    }

//    public Long getId() {
//        return id;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
