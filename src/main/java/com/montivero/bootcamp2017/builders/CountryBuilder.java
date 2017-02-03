package com.montivero.bootcamp2017.builders;

import com.montivero.bootcamp2017.domains.Country;
import org.springframework.stereotype.Repository;

@Repository
public class CountryBuilder {

    public String name="Dummy Country";
    public String shortName2="DC";
    public String shortName3="DMC";

    public CountryBuilder name(String name){
        this.name=name;
        return this;
    }

    public CountryBuilder shortName2(String shortName2){
        this.shortName2=shortName2.toUpperCase();
        return this;
    }

    public CountryBuilder shortName3(String shortName3){
        this.shortName3=shortName3.toUpperCase();
        return this;
    }

    public Country build(){
        return new Country(this);
    }

}
