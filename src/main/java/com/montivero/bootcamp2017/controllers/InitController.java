package com.montivero.bootcamp2017.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class InitController implements InitService {


    public String hello(){
        return "Init Controller Run";
    }

    public ResponseEntity<String> t(){
        return  new ResponseEntity<String>("BBBB", HttpStatus.OK);
    }


}
