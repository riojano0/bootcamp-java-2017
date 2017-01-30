package com.montivero.bootcamp2017.domains;

import com.montivero.bootcamp2017.builders.StateBuilder;

import javax.persistence.*;

@Entity
@Table(name="states")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String shortName;

    private double area;

    private String capital;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="country_id")
    private Country country;

    public State(){};

    public State(String name, String shortName, double area, String capital, Country country) {
        this.name = name;
        this.shortName = shortName;
        this.area = area;
        this.capital = capital;
        this.country = country;
    }

    public State(StateBuilder builder) {
        this.name = builder.name;
        this.shortName = builder.shortName;
        this.area = builder.area;
        this.capital = builder.capital;
        this.country = builder.country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
