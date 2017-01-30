package com.montivero.bootcamp2017.repositories;

import com.montivero.bootcamp2017.domains.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface WeatherRepository extends CrudRepository<Weather,Long> {

    List<Weather> findAll();
    Weather findByStateName(String stateName);
    Weather findByStateNameAndWeekDate(String stateName, String date);

}
