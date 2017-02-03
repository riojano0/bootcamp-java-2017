package com.montivero.bootcamp2017.services;

import javax.ws.rs.*;

public interface CountryServiceRest {

    @GET
    @Path("/get/all")
    @Produces("application/json")
    String getAllCountry();

    @GET
    @Path("/get/iso3code/{shortName3}")
    @Produces("application/json")
    String getCountryByShortName3(@PathParam("shortName3") String shortName3);

    @GET
    @Path("/get/iso3code/{shortName2}")
    @Produces("application/json")
    String getCountryByShortName2(@PathParam("shortName2") String shortName2);

    @GET
    @Path("/search")
    @Produces("application/json")
    String getCountryBySearchText(@QueryParam("text") String text);
}
