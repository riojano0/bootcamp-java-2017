package com.montivero.bootcamp2017.controllers;

import com.montivero.bootcamp2017.domains.Country;
import org.springframework.web.bind.annotation.RequestBody;

import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.List;

@WebService
@Path("/country")
public interface CountryService {

    @GET
    @Path("/")
    @Produces("application/json")
    List<Country> getAllCountries();

    @GET
    @Path("/get/id/{id}")
    @Produces("application/json")
    Country getCountryById(@PathParam("id") long id);

    @GET
    @Path("/get/name/{name}")
    Country getCountryByName(@PathParam("name") String name);

    @POST
    @Path("/saveCountry")
    @Consumes("application/json")
    String saveCountry(@RequestBody Country country);

}
