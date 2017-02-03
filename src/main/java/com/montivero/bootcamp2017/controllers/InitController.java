package com.montivero.bootcamp2017.controllers;

import com.montivero.bootcamp2017.domains.Country;
import com.montivero.bootcamp2017.services.CountryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@Path("/")
public class InitController {

//    @Resource
//    private CountryServiceRest countryServiceRest;

//    @Resource
//    private StateServiceRest stateServiceRest;

    @Autowired
    private CountryAdapter countryAdapter;

    @GET
    @Path("/")
    @Produces("application/json")
    public String hello(){
        return "Init Controller Run";
    }

    @GET
    @Path("/t")
    @Produces("application/json")
    public List<Country> hello2() throws ExecutionException, InterruptedException, IOException {
        return countryAdapter.getCountries();
    }

    @GET
    @Path("/tt/{shortName3}")
    @Produces("application/json")
    public Country hello3(@PathParam("shortName3") String shortName3){
        return  countryAdapter.getCountryShortName3(shortName3);
    }

}
