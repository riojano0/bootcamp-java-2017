package com.montivero.bootcamp2017.builders;

import com.montivero.bootcamp2017.domains.Country;
import com.montivero.bootcamp2017.domains.State;

public class StateBuilder {
    public Country country = new CountryBuilder().build();
    public String name = "Dummy State";
    public String shortName = "DUMS";
    public double area = 100;
    public String capital = "Dummy Capital";

    public StateBuilder country(Country country){
        this.country=country;
        return this;
    }

    public StateBuilder name(String name){
        this.name= name;
        return this;
    }

    public StateBuilder shortName(String shortName){
        this.shortName=shortName.toUpperCase();
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
