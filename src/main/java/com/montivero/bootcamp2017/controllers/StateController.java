package com.montivero.bootcamp2017.controllers;

import com.montivero.bootcamp2017.domains.State;
import com.montivero.bootcamp2017.repositories.CountryRepository;
import com.montivero.bootcamp2017.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import java.util.List;


@Controller
@Path("/state")
public class StateController {

    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CountryRepository countryRepository;

    @GET
    @Path("/")
    @Produces("application/json")
    public List<State> getAllStates(){

        return stateRepository.findAll();
    }

    @GET
    @Path("get/id/{id}")
    @Produces("application/json")
    public State getStateById(@PathParam("id") long id) {


        return stateRepository.findOne(id);
    }

    @POST
    @Path("/saveState")
    @Consumes("application/json")
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

    @GET
    @Path("/get/all/{name}")
    @Produces("application/json")
    public List<State> getAllStatesByCountry(@PathParam("name") String name) {
//        return stateRepository.findAllByCountryNameIgnoreCase(name);
        return stateRepository.findAllByCountry_ShortName3(name);
    }

}
