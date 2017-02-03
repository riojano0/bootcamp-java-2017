package com.montivero.bootcamp2017.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.montivero.bootcamp2017.builders.CountryBuilder;
import com.montivero.bootcamp2017.domains.Country;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CountryAdapter {

    @Resource
    private CountryServiceRest countryServiceRest;

    public CountryAdapter(){};

    public List<Country> getCountries() {
        List<Country> countries = new ArrayList<Country>();
        try{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(countryServiceRest.getAllCountry());
        JsonNode countriesJson = actualObj.get("RestResponse").get("result");

        for(JsonNode c:countriesJson){
            countries.add(new CountryBuilder()
                    .name(c.get("name").textValue())
                    .shortName2(c.get("alpha2_code").textValue())
                    .shortName3(c.get("alpha3_code").textValue())
                    .build());
        }

        return countries;
        }catch (IOException e){
            e.printStackTrace();
            return countries;
        }catch (NullPointerException e){
            e.printStackTrace();
            return countries;
        }
    }

    public Country getCountryShortName3(String shortName3){
        Country c=null;
        try {

            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(countryServiceRest.getCountryByShortName3(shortName3));
            JsonNode countryJson = actualObj.get("RestResponse").get("result");

            c = new CountryBuilder()
                    .name(countryJson.get("name").textValue())
                    .shortName2(countryJson.get("alpha2_code").textValue())
                    .shortName3(countryJson.get("alpha3_code").textValue())
                    .build();

            return c;

        }catch (IOException e){
            e.printStackTrace();
            return c;
        }catch (NullPointerException e){
            e.printStackTrace();
            return c;
        }
    }

    public Country getCountryShortName2(String shortName2){
        Country c=null;
        try {

            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(countryServiceRest.getCountryByShortName2(shortName2));
            JsonNode countryJson = actualObj.get("RestResponse").get("result");

            c = new CountryBuilder()
                    .name(countryJson.get("name").textValue())
                    .shortName2(countryJson.get("alpha2_code").textValue())
                    .shortName3(countryJson.get("alpha3_code").textValue())
                    .build();

            return c;

        }catch (IOException e){
            e.printStackTrace();
            return c;
        }catch (NullPointerException e){
            e.printStackTrace();
            return c;
        }
    }

}
