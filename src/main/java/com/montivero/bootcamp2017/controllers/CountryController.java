package com.montivero.bootcamp2017.controllers;


import com.montivero.bootcamp2017.domains.Country;
import com.montivero.bootcamp2017.adapters.CountryAdapter;
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


    // TESTS for Get JSON //

    public List<Country> getAllCountryWebService() {
        CountryAdapter countryAdapter = new CountryAdapter("http://services.groupkt.com/country/get/all");
            return  countryAdapter.getCountries();

    }

    public Country getCountryByNameWebService(String shortName3) {
        CountryAdapter countryAdapter = new CountryAdapter(
                String.format("http://services.groupkt.com/country/get/iso3code/%s",shortName3));

        return countryAdapter.getCountry();
    }


}
