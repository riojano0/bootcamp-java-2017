package com.montivero.bootcamp2017.controllers;

import com.montivero.bootcamp2017.domains.Country;
import com.montivero.bootcamp2017.services.CountryProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import java.util.List;


@Controller
@Path("/country")
@Produces("application/json")
public class CountryController{


    @Autowired
    private CountryProxy countryProxy;

    @GET
    @Path("/get/id/{id}")
    @Produces("application/json")
    public Country getCountryById(@PathParam("id") long id) {
        return countryProxy.getCountryById(id);
    }

    @GET
    @Path("/get/all")
    @Produces("application/json")
    public List<Country> getAllCountries() {
        return countryProxy.getAllCountries();
    }

    @GET
    @Path("/get/name/{shortName3}")
    @Produces("application/json")
    public Country getCountryByName(@PathParam("shortName3") String shortName3){
        return countryProxy.getCountryByShortName3(shortName3);
    }


    @POST
    @Path("/saveCountry")
    @Consumes("application/json")
    public String saveCountry(Country country){
        return countryProxy.save(country);
    }


}
