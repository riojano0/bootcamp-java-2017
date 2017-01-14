package com.montivero.bootcamp2017.Builders;

import com.montivero.bootcamp2017.Domains.Country;

/**
 * Created by Daniel on 14/01/2017.
 */
public class CountryBuilder {

    public String name;
    public String shortName2;
    public String shortName3;

    public CountryBuilder name(String name){
        this.name=name;
        return this;
    }

    public CountryBuilder shortName2(String shortName2){
        this.shortName2=shortName2;
        return this;
    }

    public CountryBuilder shortName3(String shortName3){
        this.shortName3=shortName3;
        return this;
    }

    public Country build(){
        return new Country(this);
    }

}