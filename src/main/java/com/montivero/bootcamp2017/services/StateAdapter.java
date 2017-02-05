package com.montivero.bootcamp2017.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.montivero.bootcamp2017.builders.StateBuilder;
import com.montivero.bootcamp2017.domains.Country;
import com.montivero.bootcamp2017.domains.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StateAdapter {

    @Resource
    private StateServiceRest stateServiceRest;

    @Autowired
    private CountryProxy countryProxy;

    public List<State> getStatesByCountry(String countryShortName3) {
        List<State> states = new ArrayList<State>();
        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(stateServiceRest.getAllStateByCountry(countryShortName3));
            JsonNode stateJson = actualObj.get("RestResponse").get("result");

            Country c= countryProxy.getCountryByShortName3(stateJson.get(0).get("country").textValue());

            for(JsonNode s:stateJson){
                states.add(new StateBuilder()
                                .name(s.get("name").textValue())
                                .area((Double.parseDouble(s.get("area").textValue().substring(0,s.get("area").textValue().length()-3))))
                                .capital(s.get("capital").textValue())
                                .shortName(s.get("abbr").textValue())
                                .country(c)
                                .build()
                                );
            }
            return states;
        }catch (IOException e){
            e.printStackTrace();
            return states;
        }catch (NullPointerException e){
            e.printStackTrace();
            return states;
        }
    }

    public State getStateByCountryAndShortName(String CountryShortName, String stateShortName){
        State s=null;
        try {

            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(stateServiceRest.getStateByCountryAndShortName(CountryShortName,stateShortName));
            JsonNode stateJson = actualObj.get("RestResponse").get("result");

            Country c = countryProxy.getCountryByShortName3(stateJson.get("country").textValue());

            s = new StateBuilder()
                    .name(stateJson.get("name").textValue())
                    .area((Double.parseDouble(stateJson.get("area").textValue().substring(0,stateJson.get("area").textValue().length()-3))))
                    .capital(stateJson.get("capital").textValue())
                    .shortName(stateJson.get("abbr").textValue())
                    .country(c)
                    .build();
            return s;

        }catch (IOException e){
            e.printStackTrace();
            return s;
        }catch (NullPointerException e){
            e.printStackTrace();
            return s;
        }
    }

}
