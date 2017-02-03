package com.montivero.bootcamp2017.controllers;


import com.montivero.bootcamp2017.domains.Weather;
import com.montivero.bootcamp2017.services.WeatherProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;

@Controller
@Path("/weather")
public class WeatherController{

    @Autowired
    private WeatherProxy weatherProxy;

    @GET
    @Path("/{country}/{state}")
    @Produces("application/json")
    public Weather getWeather(@PathParam("country") String countryName, @PathParam("state") String stateName){
        return weatherProxy.getWeather(countryName,stateName);
    }

    @POST
    @Path("/saveWeather")
    @Produces("application/json")
    @Consumes("application/json")
    public String saveWeather(Weather weather){
       return weatherProxy.save(weather);
    }

}
