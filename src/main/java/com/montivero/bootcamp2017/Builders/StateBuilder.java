package com.montivero.bootcamp2017.Builders;

import com.montivero.bootcamp2017.Domains.Country;
import com.montivero.bootcamp2017.Domains.State;

/**
 * Created by Daniel on 14/01/2017.
 */
public class StateBuilder {
    public Country country;
    public String name;
    public String shortName;
    public double area;
    public String capital;

    public StateBuilder country(Country country){
        this.country=country;
        return this;
    }

    public StateBuilder name(String name){
        this.name=name;
        return this;
    }

    public StateBuilder shortName(String shortName){
        this.shortName=shortName;
        return this;
    }

    public StateBuilder area(double area){
        this.area=area;
        return this;
    }

    public StateBuilder capital(String capital){
        this.capital=capital;
        return this;
    }

    public State build(){
        return new State(this);
    }

}
