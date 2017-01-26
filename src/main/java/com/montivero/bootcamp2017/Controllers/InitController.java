package com.montivero.bootcamp2017.Controllers;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Daniel on 22/01/2017.
 */

@RestController
public class InitController {

//    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
//    public String welcome() {
//
//        String welcome="<h2>Welcome</h2> <Strong> GET </strong>: </br>  /state/get/all </br>  /state/get/id/{id} </br> /state/get/name/{name} </br> " +
//                "</br> /country/get/all </br>  /country/get/id/{id} </br> /country/get/name/{name} </br> " +
//                "/state/get/country/{name} </br> " +
//                "</br> /weather/get/all </br>/weather/state/{stateName} </br>  /weather/state/{stateName}?date={} </br></br>" +
//                "<strong>POST:</strong> </br> /country/new </br> /state/new </br> /weather/new ";
//
//        return welcome;
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView welcome() {

        return new ModelAndView("index");
    }

}
