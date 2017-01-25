package com.montivero.bootcamp2017.Controllers;

import com.montivero.bootcamp2017.DataSource.CountryDataSource;
import com.montivero.bootcamp2017.Domains.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Daniel on 24/01/2017.
 */
@RestController
public class CountryController {

    @Autowired
    private CountryDataSource countryData;

    @RequestMapping(value = "country/get/all" ,method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ArrayList<Country>> countryGetAll(){
        ArrayList<Country> countries = new ArrayList<Country>();

        try{
            countries = countryData.getAllCountriesObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<ArrayList<Country>>(countries,  HttpStatus.OK);
    }

    @RequestMapping(value="/country/get/id/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Country> countryGetById(@PathVariable(value="id") int id){
        Country country=null;
        try {
            country = countryData.getCountryByIdObject(id);
        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Country>(country, HttpStatus.OK);
    }

    @RequestMapping(value="/country/get/name/{name}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Country> countryGetByName(@PathVariable(value="name") String name){
        Country country=null;
        try {
            country = countryData.getCountryByNameObject(name);
        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Country>(country, HttpStatus.OK);
    }

    @RequestMapping(value="/country/new", method= RequestMethod.POST)
    public ResponseEntity<String> countryAdd(@RequestBody Country country){
        try {
            countryData.insertCountry(country);
        }catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Fail to ad "+country.toString(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Is added ",HttpStatus.CREATED);
    }


}
