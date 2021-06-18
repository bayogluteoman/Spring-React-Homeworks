package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getCities();

    DataResult<City> addCity(City city);
}
