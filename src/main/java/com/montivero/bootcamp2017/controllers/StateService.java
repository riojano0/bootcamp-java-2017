package com.montivero.bootcamp2017.controllers;

import com.montivero.bootcamp2017.domains.State;
import org.springframework.web.bind.annotation.RequestBody;

import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.List;

@WebService
@Path("/state")
public interface StateService {

    @GET
    @Path("/")
    @Produces("application/json")
    List<State> getAllStates();

    @GET
    @Path("get/id/{id}")
    @Produces("application/json")
    State getStateById(@PathParam("id") long id);

    @POST
    @Path("/saveState")
    @Consumes("application/json")
    String SaveState(@RequestBody State state);

    @GET
    @Path("/get/all/{country}")
    @Produces("application/json")
    List<State> getAllStatesByCountry(@PathParam("country") String name);


}
