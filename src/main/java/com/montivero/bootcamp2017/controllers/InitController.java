package com.montivero.bootcamp2017.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class InitController implements InitService {

    public String hello(){
        return "AAAa";
    }

    public String t(){
        return "BBBB";
    }


}
