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

    public String stateToString(){
        return String.format("State: %s  ShortName: %s  Country: %s  Area: %sKM  Capital: %s",
                name,shortName,country.getName(),area,capital);
    }

    public Country getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public double getArea() {
        return area;
    }

    public String getCapital() {
        return capital;
    }

}
