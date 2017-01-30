package com.montivero.bootcamp2017.controllers;

import com.montivero.bootcamp2017.domains.State;
import com.montivero.bootcamp2017.repositories.CountryRepository;
import com.montivero.bootcamp2017.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Daniel on 29/01/2017.
 */
@Controller
public class StateController implements StateService {

    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CountryRepository countryRepository;


    public List<State> getAllStates(){

        return stateRepository.findAll();
    }

    public State getStateById(long id) {
        return stateRepository.findOne(id);
    }

    public String SaveState(@RequestBody State state){

        try{
            if(countryRepository.findByName(state.getCountry().getName())==null)
                countryRepository.save(state.getCountry());

            state.setCountry(countryRepository.findByName(state.getCountry().getName()));
            stateRepository.save(state);

        return "Added";
        }
        catch (Exception E){
            System.out.println(E.toString());
            return "Fail to added";
        }
    }

    public List<State> getAllStatesByCountry(String name) {
        return stateRepository.findAllByCountryNameIgnoreCase(name);
    }

}
