package com.montivero.bootcamp2017.Controllers;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Daniel on 22/01/2017.
 */

@RestController
public class TestController {

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "Welcome";
    }
    @RequestMapping("/t/s")
    public ResponseEntity<String> testString(){
        return new ResponseEntity<String>("String!!! Wuau!", HttpStatus.OK);
    }

    @RequestMapping(value = "/t/c" ,method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ArrayList<String>> testColec(){
        ArrayList<String> listString = new ArrayList<String>();
        listString.add("One String");
        listString.add("Two String");

        return new ResponseEntity<ArrayList<String>>(listString,  HttpStatus.OK);
    }

}
