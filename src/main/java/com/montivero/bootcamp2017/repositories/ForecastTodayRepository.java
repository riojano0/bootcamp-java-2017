package com.montivero.bootcamp2017.repositories;


import com.montivero.bootcamp2017.domains.ForecastToday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ForecastTodayRepository extends CrudRepository<ForecastToday,Long> {

    List<ForecastToday> findByDateAndTemp(String date, int temp);

}
