package com.montivero.bootcamp2017.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Daniel on 22/01/2017.
 */

@RestController
public class InitController {

    //Method copy from other site to check Models
//    private static int counter = 0;
//    private static final String VIEW_INDEX = "index";
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String welcome(ModelMap model) {
//
//        model.addAttribute("message", "Welcome");
//        model.addAttribute("counter", ++counter);
//
//        return VIEW_INDEX;
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String welcome() {

        String welcome="<h2>Welcome</h2> <Strong> GET </strong>: </br>  /state/get/all </br>  /state/get/id/{id} </br> /state/get/name/{name} </br> " +
                "</br> /country/get/all </br>  /country/get/id/{id} </br> /country/get/name/{name} </br> " +
                "</br> /weather/get/all </br>/weather/today/state/{stateName} </br>  /weather/get/today (is not update)</br></br>" +
                "<strong>POST:</strong> </br> /country/new </br> state/new </br> /weather/new (Still not work) ";

        return welcome;
    }

    @RequestMapping(value = "/t/c" ,method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ArrayList<String>> testColec(){
        ArrayList<String> listString = new ArrayList<String>();
        listString.add("One String");
        listString.add("Two String");

        return new ResponseEntity<ArrayList<String>>(listString,  HttpStatus.OK);
    }

}
