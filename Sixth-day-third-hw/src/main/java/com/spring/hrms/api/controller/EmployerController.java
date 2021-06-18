package com.spring.hrms.api.controller;

import com.spring.hrms.business.abstracts.ActivationCodeService;
import com.spring.hrms.business.abstracts.EmployerRegisterService;
import com.spring.hrms.business.abstracts.EmployerService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.entities.abstracts.User;
import com.spring.hrms.entities.concretes.Employer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
    private final EmployerService employerService;
    private final EmployerRegisterService employerRegisterService;
    private final ActivationCodeService activationCodeService;

    public EmployerController(EmployerService employerService, EmployerRegisterService employerRegisterService, ActivationCodeService activationCodeService) {
        this.employerService = employerService;
        this.employerRegisterService = employerRegisterService;
        this.activationCodeService = activationCodeService;
    }

    @GetMapping("/getall")
    public DataResult getAll(){
        return employerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer) throws Exception {
        return employerRegisterService.register(employer);
    }


}
