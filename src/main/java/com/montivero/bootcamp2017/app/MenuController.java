package com.montivero.bootcamp2017.app;

import com.montivero.bootcamp2017.Builders.CountryBuilder;
import com.montivero.bootcamp2017.DataSource.CountryDataSource;
import com.montivero.bootcamp2017.DataSource.StateDataSource;
import com.montivero.bootcamp2017.DataSource.WeatherDataSource;
import com.montivero.bootcamp2017.Domains.Country;
import com.montivero.bootcamp2017.Domains.State;
import com.montivero.bootcamp2017.Domains.Weather;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by Daniel on 22/01/2017.
 */
@RestController
public class MenuController {

    private ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    private StateDataSource sData = (StateDataSource) context.getBean("stateData");
    private CountryDataSource cData = (CountryDataSource) context.getBean("countryData");
    private WeatherDataSource wData = (WeatherDataSource) context.getBean("weatherData");

    @RequestMapping("weather/get/all")
    public ArrayList<Weather> weathersGetAll(){
        ArrayList<Weather> weathers = null;
        try {
            weathers = wData.getAllWeathersObjects();
        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return weathers;
    }

    @RequestMapping("/country/get/all")
    public ArrayList<Country> countryGetAll(){
        ArrayList<Country> countries = null;
        try {
            countries = cData.getAllCountriesObjects();
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
        return countries;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/state/get/all",method = RequestMethod.GET)
    public ArrayList<State> stateGetAll(){
        ArrayList<State> states = null;
        try {
            states = sData.getAllStatesObjects();
        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return states;

    }

    @RequestMapping("/state/get/{id}")
    public State stateGetById(@PathVariable(value="id") int id){
        State state=null;
        try {
            state = sData.getStateByIdObject(id);
        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return state;

    }

    @RequestMapping("/test")
    public ArrayList<Country> test(){
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(new CountryBuilder().build());

        return countries;
    }

}
