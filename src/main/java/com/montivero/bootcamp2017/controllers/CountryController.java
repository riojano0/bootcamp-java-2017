package com.montivero.bootcamp2017.controllers;

import com.montivero.bootcamp2017.domains.Country;
import com.montivero.bootcamp2017.services.CountryProxy;
import com.mysql.fabric.xmlrpc.base.MethodResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.*;
import java.util.List;


@Controller
@Path("/country")
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
    @Produces("application/json")
    public String saveCountry(@RequestBody Country country){

        return countryProxy.save(country);
    }


}
