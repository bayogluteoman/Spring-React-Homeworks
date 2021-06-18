package com.spring.hrms.business.concretes;

import com.spring.hrms.business.abstracts.CityService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.core.utilities.results.SuccessDataResult;
import com.spring.hrms.core.utilities.results.SuccessResult;
import com.spring.hrms.dataAccess.abstracts.CityRepository;
import com.spring.hrms.entities.concretes.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public DataResult<List<City>> getCities() {
        return new SuccessDataResult<List<City>>(cityRepository.findAll());
    }

    @Override
    public DataResult<City> addCity(City city) {
        cityRepository.save(city);
        return new SuccessDataResult<City>(city,"Succesfully added.");
    }
}
