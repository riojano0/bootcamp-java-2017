package com.montivero.bootcamp2017.controllers;

import com.montivero.bootcamp2017.domains.Weather;

import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.List;

@WebService
@Path("/weather")
public interface WeatherService {

    @GET
    @Path("/")
    @Produces("application/json")
    List<Weather> getAllWeather();

    @GET
    @Path("/get/state/{name}")
    @Produces("application/json")
    List<Object> getWeatherForName(@PathParam("name") String name, @QueryParam(value="date") String date);


    @POST
    @Path("/saveWeather")
    @Produces("application/json")
    String saveWeather(Weather weather);

}
