package com.montivero.bootcamp2017.repositories;

import com.montivero.bootcamp2017.domains.Wind;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface WindRepository extends CrudRepository<Wind,Long> {

    List<Wind> findBySpeedAndDirection(int speed, int direction);
}
