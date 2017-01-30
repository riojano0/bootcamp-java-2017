package com.montivero.bootcamp2017.repositories;

import com.montivero.bootcamp2017.domains.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CountryRepository extends CrudRepository<Country,Long> {

    List<Country> findAll();
    Country findByName(String name);
}
