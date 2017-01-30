package com.montivero.bootcamp2017.services;

import javax.jws.WebService;
import javax.ws.rs.Produces;


@WebService
@Produces("application/json")
public class TestService implements TestInterface{


    public String  test() {
        return "En la eterna busqueda de como conectarse a http://services.groupkt.com/country/get/all";
    }

}
