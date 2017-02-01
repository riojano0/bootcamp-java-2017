package com.montivero.bootcamp2017.services;

import javax.ws.rs.*;

public interface TestInterface {

    @GET
    @Produces("application/json")
    @Path("/state/get/IND/all")
    public String allCountries(String s);

}
