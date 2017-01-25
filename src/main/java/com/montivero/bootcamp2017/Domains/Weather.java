package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.WeatherBuilder;

/**
 * Created by Daniel on 09/01/2017.
 */
public class Weather {

    private State state;
    private String description;
    private Wind wind;
    private Atmosphere atmosphere;
    private ForecastToday today;
    private ForecastExtended[] week;



    public Weather(WeatherBuilder builder){
        this.state = builder.state;
        this.today = builder.today;
        this.week = builder.week;
        this.wind = builder.wind;
        this.atmosphere = builder.atmosphere;
        this.description = builder.description;
    }

    @Override
    public String toString(){
        String forecastExtendedOut = "";
        if(week !=null) {
            for (ForecastExtended aWeek : week) {
                if (aWeek!=null)
                forecastExtendedOut += aWeek.toString() + "\n";
            }
        }
        return String.format("Weather State:\n%s \n\n%s \n\n%s \n\n%s"+
                        "\n\nDescription: %s \n\n%s ",
                state.getName(),
                today.toString(),
                atmosphere.toString(),
                wind.toString(),
                description,
                forecastExtendedOut
        );
    }

    public State getState() {
        return state;
    }

    public ForecastToday getToday() {
        return today;
    }

    public ForecastExtended[] getWeek() {
        return week;
    }

    public Wind getWind() {
        return wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public String getDescription() {
        return description;
    }

}
