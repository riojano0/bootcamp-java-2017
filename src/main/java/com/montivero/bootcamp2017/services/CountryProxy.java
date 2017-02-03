package com.montivero.bootcamp2017.services;

import com.montivero.bootcamp2017.domains.Country;
import com.montivero.bootcamp2017.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryProxy {

    @Autowired
    private CountryAdapter countryAdapter;

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries(){

        if(countryAdapter.getCountries().isEmpty() || countryAdapter.getCountries() == null ){
            return countryRepository.findAll();
        }
        else{
            return countryAdapter.getCountries();
        }
    }

    public Country getCountryByShortName3(String shortName3){
        if(countryAdapter.getCountryShortName3(shortName3) == null ){
            return countryRepository.findByShortName3(shortName3);
        }
        else{
            return countryAdapter.getCountryShortName3(shortName3);
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
