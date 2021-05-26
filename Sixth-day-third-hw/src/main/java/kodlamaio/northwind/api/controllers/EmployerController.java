package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ActivationCodeService;
import kodlamaio.northwind.business.abstracts.EmployerRegisterService;
import kodlamaio.northwind.business.abstracts.EmployerService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Employer;
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