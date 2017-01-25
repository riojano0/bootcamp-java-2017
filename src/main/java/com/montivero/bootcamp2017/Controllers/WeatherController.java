package com.montivero.bootcamp2017.Controllers;

import com.montivero.bootcamp2017.DataSource.WeatherDataSource;
import com.montivero.bootcamp2017.Domains.ForecastExtended;
import com.montivero.bootcamp2017.Domains.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by Daniel on 24/01/2017.
 */
@RestController
public class WeatherController {

    @Autowired
    WeatherDataSource weatherData;

    @RequestMapping(value = "weather/get/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ArrayList<Weather>> weatherGetAll() {
        ArrayList<Weather> weathers = new ArrayList<Weather>();

        try {
            weathers = weatherData.getAllWeathersObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<ArrayList<Weather>>(weathers, HttpStatus.OK);
    }

//    @RequestMapping(value = "weather/state/{stateName}", method = RequestMethod.GET, produces = "application/json")
//    public ResponseEntity<Weather> weatherTodayByState(@PathVariable(value = "stateName") String stateName) {
//        Weather weather = null;
//        try {
//            weather = weatherData.getWeatherByStateNameObject(stateName);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<Weather>(weather, HttpStatus.OK);
//    }

    @RequestMapping(value = "weather/state/{stateName}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ArrayList<Object>> weatherTodayByState(@PathVariable(value = "stateName") String stateName, @RequestParam(value="date", required = false) String date) {
        ArrayList<Object> aList = new ArrayList<Object>();
        Weather weather = null;
        try {
            weather = weatherData.getWeatherByStateNameObject(stateName);
            if(date!=null){
                aList.add(weather.getState());
                for(ForecastExtended fExt: weather.getWeek()){
                    if (fExt.getDate().equals(date)){
                        aList.add(fExt);
                    }
                }
              }
            else{
                aList.add(weather);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<ArrayList<Object>>(aList, HttpStatus.OK);
    }

    @RequestMapping(value = "weather/get/today", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ArrayList<Object>> weatherTodayByState() {
        Weather weather = null;
        ArrayList<Object> todayArray = new ArrayList<Object>();

        try {
            weather = weatherData.getWeatherByIdObject(1);
            todayArray.add(weather.getState());
            todayArray.add(weather.getToday());
            todayArray.add(weather.getWind());
            todayArray.add(weather.getAtmosphere());
            todayArray.add(weather.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<ArrayList<Object>>(todayArray, HttpStatus.OK);
    }

    @RequestMapping(value = "weather/new", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> weatherTodayByState(@RequestBody Weather weather) {
        try {
            weatherData.insertWeather(weather);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<String>("weather not Added", HttpStatus.BAD_REQUEST);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<String>("weather not Added", HttpStatus.BAD_REQUEST);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("weather Added", HttpStatus.CREATED);
    }


}