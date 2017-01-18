package com.montivero.bootcamp2017.Builders;

import com.montivero.bootcamp2017.Domains.Atmosphere;

/**
 * Created by Daniel on 14/01/2017.
 */
public class AtmosphereBuilder {
    public int humidity = 10;
    public double pressure = 20.2;
    public double visibility = 200;
    public int rising = 15;

    public AtmosphereBuilder humidity(int humidity){
        this.humidity=humidity;
        return this;
    }

    public AtmosphereBuilder pressure(double pressure){
        this.pressure=pressure;
        return this;
    }

    public AtmosphereBuilder visibility(double visibility){
        this.visibility=visibility;
        return this;
    }

    public AtmosphereBuilder rising(int rising){
        this.rising=rising;
        return this;
    }

    public Atmosphere build(){
        return new Atmosphere(this);
    }

}
