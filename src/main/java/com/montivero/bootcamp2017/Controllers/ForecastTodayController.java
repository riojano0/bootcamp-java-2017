package com.montivero.bootcamp2017.Controllers;

import com.montivero.bootcamp2017.DataSource.ForecastTodayDataSource;
import com.montivero.bootcamp2017.Domains.ForecastToday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by Daniel on 24/01/2017.
 */
@RestController
public class ForecastTodayController {
    @Autowired
    ForecastTodayDataSource forecastTodayData;

    @RequestMapping(value = "today/get/all" ,method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ArrayList<ForecastToday>> forecastTodayGetAll(){
        ArrayList<ForecastToday> forecastTodays = new ArrayList<ForecastToday>();

        try{
            forecastTodays  = forecastTodayData.getAllForecastTodayObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<ArrayList<ForecastToday>>(forecastTodays, HttpStatus.OK);
    }

    @RequestMapping(value = "today/new", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> forecastTodayInsert(@RequestBody ForecastToday forecastToday) {
        try {
            forecastTodayData.insertForecastToday(forecastToday);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Today not Added", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Today Added", HttpStatus.CREATED);
    }



}
