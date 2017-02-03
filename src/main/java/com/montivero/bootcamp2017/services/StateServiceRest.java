package com.montivero.bootcamp2017.services;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

public interface StateServiceRest {

    @GET
    @Path("/get/{countryCode}/all/")
    @Produces("application/json")
    String getAllStateByCountry(@PathParam("countryCode") String countryCode);

    @GET
    @Path("/get/{country}/{shortName}")
    @Produces("application/json")
    String getStateByCountryAndShortName(@PathParam("country") String country,@PathParam("shortName") String shortName);


}
