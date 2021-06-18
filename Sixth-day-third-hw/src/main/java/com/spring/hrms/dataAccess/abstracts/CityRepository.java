package com.spring.hrms.dataAccess.abstracts;

import com.spring.hrms.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    boolean existsById(int id);

}
