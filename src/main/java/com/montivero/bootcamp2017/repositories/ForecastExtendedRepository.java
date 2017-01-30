package com.montivero.bootcamp2017.repositories;

import com.montivero.bootcamp2017.domains.ForecastExtended;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ForecastExtendedRepository extends CrudRepository<ForecastExtended,Long> {

    List<ForecastExtended> findAll();
    List<ForecastExtended> findByDateAndDescriptionAndTempMaxAndTempMin(String date, String description, int tempMax, int tempMin);
}
