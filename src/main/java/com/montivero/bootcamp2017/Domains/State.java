package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.StateBuilder;

public class State {

    private Country country;
    private String name;
    private String shortName;
    private double area;
    private String capital;

    public State(StateBuilder builder) {
        this.country = builder.country;
        this.name = builder.name;
        this.shortName = builder.shortName;
        this.area = builder.area;
        this.capital = builder.capital;
    }

    public Country getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getShort_name() {
        return shortName.toUpperCase();
    }

    public double getArea() {
        return area;
    }

    public String getCapital() {
        return capital;
    }

}
