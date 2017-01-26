package com.montivero.bootcamp2017.Builders;

import com.montivero.bootcamp2017.Domains.ForecastExtended;

/**
 * Created by Daniel on 14/01/2017.
 */
public class ForecastExtendedBuilder {

    public String date = "21/06/2016";
    public int day = 1;
    public int tempMin = 20;
    public int tempMax = 30;
    public String description = "Cloudy";

    public ForecastExtendedBuilder date(String date) {
        this.date =  date;
        return this;
    }

    public ForecastExtendedBuilder day(int day){
        this.day = day;
        return this;
    }

    public ForecastExtendedBuilder tempMin(int tempMin){
        this.tempMin=tempMin;
        return this;
    }

    public ForecastExtendedBuilder tempMax(int tempMax){
        this.tempMax=tempMax;
        return this;
    }

    public ForecastExtendedBuilder description(String description){
        this.description=description;
        return this;
    }

    public ForecastExtended build(){
        return new ForecastExtended(this);
    }

}
