package com.montivero.bootcamp2017.services;

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
        if (stateAdapter.getStatesByCountry(countryShortName).isEmpty() || stateAdapter.getStatesByCountry(countryShortName) == null ) {
            return stateRepository.findAllByCountry_ShortName3(countryShortName);
        }else{
            return stateAdapter.getStatesByCountry(countryShortName);
        }
    }

    public State getStateByCountryAndShortName(String countryShortName,String stateShortName){
        if(stateAdapter.getStateByCountryAndShortName(countryShortName,stateShortName)!=null)
            return stateAdapter.getStateByCountryAndShortName(countryShortName,stateShortName);
        else
            try {
                return stateRepository.findOneByCountry_ShortName3AndShortName(countryShortName,stateShortName);
            }catch (IncorrectResultSizeDataAccessException E){
                return null;
            }

    }

    public String save(State state){
        try{
            if(countryRepository.findByName(state.getCountry().getName())==null) {
                countryRepository.save(state.getCountry());
            }


            state.setCountry(countryRepository.findByName(state.getCountry().getName()));
            stateRepository.save(state);

        return "Added";
        }
        catch (Exception E){
            E.toString();
            return "Fail to added "+state.getCountry().toString() + "\n" + state.toString();

        }
    }


}
