package com.montivero.bootcamp2017.Builders;

import com.montivero.bootcamp2017.Domains.Country;
import org.apache.commons.lang3.text.WordUtils;

/**
 * Created by Daniel on 14/01/2017.
 */
public class CountryBuilder {

    public String name="Dummy Country";
    public String shortName2="DC";
    public String shortName3="DMC";

    public CountryBuilder name(String name){
        this.name=WordUtils.capitalizeFully(name);
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
