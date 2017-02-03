package com.montivero.bootcamp2017.repositories;


import com.montivero.bootcamp2017.domains.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StateRepository extends CrudRepository<State,Long> {

    List<State> findAll();
    List<State> findAllByCountryNameIgnoreCase(String countryName);
    State       findByName(String stateName);
    List<State> findByNameAndCountryName(String stateName, String countryName);
    List<State> findAllByCountry_ShortName3(String shortName3);
    State       findOneByCountry_ShortName3AndShortName(String countryShortName, String stateShortName);

}
