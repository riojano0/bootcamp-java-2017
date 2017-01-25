package com.montivero.bootcamp2017.Controllers;

import com.montivero.bootcamp2017.DataSource.WeatherDataSource;
import com.montivero.bootcamp2017.Domains.Country;
import com.montivero.bootcamp2017.Domains.State;
import com.montivero.bootcamp2017.Domains.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
public class WeatherController {

    @Autowired
    WeatherDataSource weatherData;

    @RequestMapping(value = "weather/get/all" ,method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ArrayList<Weather>> weatherGetAll(){
        ArrayList<Weather> weathers = new ArrayList<Weather>();

        try{
            weathers  = weatherData.getAllWeathersObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<ArrayList<Weather>>(weathers, HttpStatus.OK);
    }

    @RequestMapping(value = "weather/today/state/{stateName}" ,method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Weather> weatherTodayByState(@PathVariable(value="stateName") String stateName){
        Weather weather=null;
        try {
            weather = weatherData.getWeatherByStateNameObject(stateName);
        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Weather>(weather, HttpStatus.OK);
    }


}
