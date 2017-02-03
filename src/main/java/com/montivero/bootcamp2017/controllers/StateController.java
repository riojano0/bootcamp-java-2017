package com.montivero.bootcamp2017.controllers;

import com.montivero.bootcamp2017.domains.State;
import com.montivero.bootcamp2017.services.StateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import java.util.List;


@Controller
@Path("/state")
public class StateController {

    @Autowired
    private StateProxy stateProxy;

    @GET
    @Path("/get/all/{countryShortName}")
    @Produces("application/json")
    public List<State> getAllStatesByCountry(@PathParam("countryShortName") String countryShortName) {
        return stateProxy.getStatesByCountry(countryShortName);
    }

    @GET
    @Path("/get/{country}/{state}")
    @Produces("application/json")
    public State getStateByCountryAndShortName(@PathParam("country") String countryShortName,@PathParam("state") String stateShortName){
        return stateProxy.getStateByCountryAndShortName(countryShortName,stateShortName);
    }

    @POST
    @Path("/saveState")
    @Consumes("application/json")
    public String SaveState(@RequestBody State state){
        return stateProxy.save(state);
    }



}
