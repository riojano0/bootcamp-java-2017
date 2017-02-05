package com.montivero.bootcamp2017.services;

import com.montivero.bootcamp2017.domains.Country;
import com.montivero.bootcamp2017.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.xml.ws.Response;
import java.util.List;

@Component
public class CountryProxy {

    @Autowired
    private CountryAdapter countryAdapter;

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries(){

        List<Country> countries = countryAdapter.getCountries();
        if(countries.isEmpty()){
            return countryRepository.findAll();
        }
        else{
            return countries;
        }
    }

    public Country getCountryByShortName3(String shortName3){
        Country country = countryAdapter.getCountryShortName3(shortName3);
        if(country == null ){
            return countryRepository.findByShortName3(shortName3);
        }
        else{
            return country;
        }
    }

    public Country getCountryById(long id){

        try {
            return countryAdapter.getCountries().get((int) id);
        }catch (IndexOutOfBoundsException e){
            return countryRepository.findOne(id);
        }
    }

    public String save(Country country){
        try{
            if(countryRepository.findByName(country.getName())==null) {
                countryRepository.save(country);
                return "Added";
            }else{
                return "The Country already exists";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "Not added, error";
        }
    }

}
