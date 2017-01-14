package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.CountryBuilder;

public class Country {

    final private String name;
    final private String shortName2;
    final private String shortName3;

    public Country(CountryBuilder builder){
        this.name = builder.name;
        this.shortName2 = builder.shortName2;
        this.shortName3 =  builder.shortName3;
    }

    public String getName() {
        return name;
    }

    public String getShort_name_2() {
        return shortName2.toUpperCase();
    }

    public String getShort_name_3() {
        return shortName3.toUpperCase();
    }

}
