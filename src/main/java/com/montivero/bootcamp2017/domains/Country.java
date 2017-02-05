package com.montivero.bootcamp2017.domains;

import com.montivero.bootcamp2017.builders.CountryBuilder;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id" )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column (name = "shortName2")
    private String shortName2;

    @Column (name = "shortName3")
    private String shortName3;

    public Country(){};

    public Country(String name, String shortName2, String shortName3) {
        this.name = name;
        this.shortName2 = shortName2;
        this.shortName3 = shortName3;
    }

    public Country(CountryBuilder builder){
        this.name = builder.name;
        this.shortName2 = builder.shortName2;
        this.shortName3 = builder.shortName3;
    }

    @Override
    public String toString() {
        return String.format("Country: %s  ShortName2: %s  ShortName3: %s", name, shortName2, shortName3);
    }

//    public Long getId() {
//        return id;
//    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName2() {
        return shortName2;
    }

    public void setShortName2(String shortName2) {
        this.shortName2 = shortName2;
    }

    public String getShortName3() {
        return shortName3;
    }

    public void setShortName3(String shortName3) {
        this.shortName3 = shortName3;
    }


}
