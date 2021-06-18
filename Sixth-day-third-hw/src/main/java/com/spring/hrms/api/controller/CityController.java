package com.spring.hrms.api.controller;


import com.spring.hrms.business.abstracts.CityService;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.entities.concretes.City;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getAll")
    public Result getAll(){
        return cityService.getCities();
    }

    @PostMapping("/add")
    public Result addCity(@RequestBody City city){
        return cityService.addCity(city);
    }

}
