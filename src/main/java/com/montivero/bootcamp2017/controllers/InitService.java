package com.montivero.bootcamp2017.controllers;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@WebService
public interface InitService {

    @GET
    @Path("/")
    @Produces("application/json")
    public String hello();

    @GET
    @Path("/t")
    @Produces("application/json")
    public String t();
}
