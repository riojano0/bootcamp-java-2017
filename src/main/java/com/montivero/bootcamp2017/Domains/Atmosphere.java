package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.AtmosphereBuilder;

/**
 * Created by Daniel on 09/01/2017.
 */
public class Atmosphere {

    private int humidity;
    private double pressure;
    private double visibility;
    private int rising;

    public Atmosphere(AtmosphereBuilder builder) {
        this.humidity = builder.humidity;
        this.pressure = builder.pressure;
        this.visibility = builder.visibility;
        this.rising = builder.rising;
    }

    public String atmosphereToString(){
        return String.format("Atmosphere: \nHumidity: %s \nPressure: %s \nVisibility: %s \nRising: %s",
                humidity,
                pressure,
                visibility,
                rising);
    }

    public int getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public double getVisibility() {
        return visibility;
    }

    public int getRising() {
        return rising;
    }

}
