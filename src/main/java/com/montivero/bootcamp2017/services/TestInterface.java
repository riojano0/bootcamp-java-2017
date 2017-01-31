package com.montivero.bootcamp2017.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Produces("application/json")
@Consumes("application/json")
@Path("/sampleService")
public interface TestInterface {

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/saveForm")
    public String saveFrom(String signupForm);

}
