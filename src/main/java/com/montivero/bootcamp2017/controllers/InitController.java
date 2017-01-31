package com.montivero.bootcamp2017.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GET
    @Path("/t")
    @Produces("application/json")
    public ResponseEntity<String> t(){
        return  new ResponseEntity<String>("BBBB", HttpStatus.OK);
    }


}
