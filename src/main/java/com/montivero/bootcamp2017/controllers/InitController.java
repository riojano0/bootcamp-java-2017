package com.montivero.bootcamp2017.controllers;

import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Controller
@Path("/")
public class InitController {

    @GET
    @Path("/")
    @Produces("application/json")
    public String hello(){
        return "Init Controller Run";
    }



}
