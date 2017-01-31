package com.montivero.bootcamp2017.controllers;
import com.montivero.bootcamp2017.domains.Country;
import com.montivero.bootcamp2017.adapters.CountryAdapter;
import com.montivero.bootcamp2017.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import javax.ws.rs.*;
import java.util.List;

@Controller
@Path("/country")
@Produces("application/json")
public class CountryController{

    @Autowired
    private CountryRepository countryRepository;

    @GET
    @Path("/get/id/{id}")
    @Produces("application/json")
    public Country getCountryById(@PathParam("id") long id) {
        return countryRepository.findOne(id);
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @GET
    @Path("/get/name/{name}")
    @Produces("application/json")
    public Country getCountryByName(@PathParam("name") String name){
        return countryRepository.findByName(name);
    }

    @POST
    @Path("/saveCountry")
    @Consumes("application/json")
    public String saveCountry(Country country){
        countryRepository.save(country);
        return "Added";
    }


    // TESTS for Get JSON //

    @GET
    @Path("/test")
    @Produces("application/json")
    public List<Country> getAllCountryWebService() {
        CountryAdapter countryAdapter = new CountryAdapter("http://services.groupkt.com/country/get/all");
            return  countryAdapter.getCountries();

    }

    @GET
    @Path("/test/{shortName3}")
    @Produces("application/json")
    public Country getCountryByNameWebService(@PathParam("shortName3") String shortName3) {
        CountryAdapter countryAdapter = new CountryAdapter(
                String.format("http://services.groupkt.com/country/get/iso3code/%s",shortName3));

        return countryAdapter.getCountry();
    }


}
