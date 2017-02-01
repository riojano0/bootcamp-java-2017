package com.montivero.bootcamp2017.services;

import javax.ws.rs.*;

@Path("/")
@Produces("application/json")
public interface CountryServiceInterface {

    @GET
    @Produces("application/json")
    @Path("/state/get/IND/all")
    public String getAllCountries(String s);

}
