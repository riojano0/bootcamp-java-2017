package com.montivero.bootcamp2017.services;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


//@WebService(targetNamespace = "http://services.groupkt.com/state/get/IND/all")
@WebService
@Produces("application/json")
public interface TestInterface {

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/")
    public String test();


}
