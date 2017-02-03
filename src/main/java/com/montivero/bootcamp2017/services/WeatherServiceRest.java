package com.montivero.bootcamp2017.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

public interface WeatherServiceRest {

    @GET
    @Path("/")
    @Produces("application/json")
    String getWeather(@QueryParam("q") String query,@QueryParam("format") String format);
}
