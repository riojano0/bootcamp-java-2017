package com.montivero.bootcamp2017.controllers;


import com.montivero.bootcamp2017.domains.Country;
import com.montivero.bootcamp2017.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CountryController implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country getCountryById(long id) {
        return countryRepository.findOne(id);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryByName(String name){
        return countryRepository.findByName(name);
    }

    public String saveCountry(Country country){
        countryRepository.save(country);
        return "Added";
    }

}
