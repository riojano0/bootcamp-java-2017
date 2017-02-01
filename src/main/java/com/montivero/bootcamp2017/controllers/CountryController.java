package com.montivero.bootcamp2017.controllers;

import com.montivero.bootcamp2017.adapters.CountryJsonAdapter;
import com.montivero.bootcamp2017.builders.CountryBuilder;
import com.montivero.bootcamp2017.domains.Country;
import com.montivero.bootcamp2017.repositories.CountryRepository;
import com.sun.jersey.api.client.Client;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import java.util.ArrayList;
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

        CountryJsonAdapter countryJsonAdapter = new CountryJsonAdapter("http://services.groupkt.com/country/get/all");

            return  countryJsonAdapter.getCountries();
    }

    @GET
    @Path("/test2")
    @Produces("application/json")
    public List<Country> test2() {

        Client c = Client.create();
        String response = c.resource("http://services.groupkt.com/country/get/all")
                .accept("application/json; charset=utf-8")
                .get(String.class);

        JSONObject json = new JSONObject(response);
        JSONArray jsonArray = json.getJSONObject("RestResponse").getJSONArray("result");

        List<Country> countries = new ArrayList<Country>();
        for(int i=0;i<jsonArray.length();i++){
            countries.add(new CountryBuilder()
                    .name(jsonArray.getJSONObject(i).get("name").toString())
                    .shortName2(jsonArray.getJSONObject(i).get("alpha2_code").toString())
                    .shortName3(jsonArray.getJSONObject(i).get("alpha3_code").toString())
                    .build()
                    );
        }


//        return response;
        return countries;
    }



    @GET
    @Path("/test/{shortName3}")
    @Produces("application/json")
    public Country getCountryByNameWebService(@PathParam("shortName3") String shortName3) {
        CountryJsonAdapter countryJsonAdapter = new CountryJsonAdapter(
                String.format("http://services.groupkt.com/country/get/iso3code/%s",shortName3));

        return countryJsonAdapter.getCountry();
    }


}
