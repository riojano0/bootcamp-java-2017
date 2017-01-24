package com.montivero.bootcamp2017.Domains;

import com.montivero.bootcamp2017.Builders.CountryBuilder;

public class Country {

    private String name;
    private String shortName2;
    private String shortName3;

    public Country(){};

    public Country(CountryBuilder builder){
        this.name = builder.name;
        this.shortName2 = builder.shortName2;
        this.shortName3 =  builder.shortName3;
    }

    @Override
    public String toString(){
        return String.format("Country: %s  Alpha2: %s  Alpha3: %s",name,shortName2,shortName3);
    }

    public String getName(){
        return name;
    }

    public String getShortName2() {
        if(shortName2!=null) {
            return shortName2.toUpperCase();
        }
        else{
            return null;
        }
    }

    public String getShortName3() {
        if(shortName3!=null) {
            return shortName3.toUpperCase();
        }
        else{
            return null;
        }
    }

}
