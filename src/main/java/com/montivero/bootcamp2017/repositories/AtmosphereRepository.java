package com.montivero.bootcamp2017.repositories;

import com.montivero.bootcamp2017.domains.Atmosphere;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AtmosphereRepository extends CrudRepository<Atmosphere,Long> {
    List<Atmosphere> findByHumidityAndPressureAndRisingAndVisibility(int humidity, double pressure, int rising, double visibility);
}

