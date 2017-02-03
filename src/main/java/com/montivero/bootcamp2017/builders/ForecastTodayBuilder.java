package com.montivero.bootcamp2017.builders;

import com.montivero.bootcamp2017.domains.ForecastToday;

public class ForecastTodayBuilder {
    public String date = "17/06/2017";
    public int temp = 45;

    public ForecastTodayBuilder date(String date) {
        this.date =  date;
        return this;
    }

    public ForecastTodayBuilder temp(int temp){
        this.temp = temp;
        return this;
    }

    public ForecastToday build(){
        return new ForecastToday(this);
    }

}
