package com.montivero.bootcamp2017.services;

import com.montivero.bootcamp2017.domains.Country;
import com.montivero.bootcamp2017.domains.State;
import com.montivero.bootcamp2017.repositories.CountryRepository;
import com.montivero.bootcamp2017.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StateProxy {

    @Autowired
    private StateAdapter stateAdapter;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;


    public List<State> getStatesByCountry(String countryShortName){
        List<State> states =  stateAdapter.getStatesByCountry(countryShortName);
        if (states.isEmpty()) {
            return stateRepository.findAllByCountry_ShortName3(countryShortName);
        }else{
            return states;
        }
    }

    public State getStateByCountryAndShortName(String countryShortName,String stateShortName){
        State state = stateAdapter.getStateByCountryAndShortName(countryShortName,stateShortName);
        if(state !=null)
            return state;
        else
            try {
                return stateRepository.findOneByCountry_ShortName3AndShortName(countryShortName,stateShortName);
            }catch (IncorrectResultSizeDataAccessException E){
                return null;
            }

    }

    public String save(State state){
        try{
            Country country = countryRepository.findByName(state.getCountry().getName());
            if(country==null) {
                countryRepository.save(state.getCountry());
            }

            state.setCountry(countryRepository.findByName(state.getCountry().getName()));
            stateRepository.save(state);

        return "Added";
        }
        catch (Exception E){
            E.printStackTrace();
            return "Fail to added "+state.getCountry().toString() + "\n" + state.toString();

        }
    }


}
