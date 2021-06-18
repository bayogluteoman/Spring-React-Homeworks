package com.spring.hrms.api.controller;

import com.spring.hrms.business.abstracts.ActivationCodeService;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.entities.concretes.ActivationCodeCandidate;
import com.spring.hrms.entities.concretes.ActivationCodeEmployer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activation")
public class ActivationController {
    private final ActivationCodeService activationCodeService;

    public ActivationController(ActivationCodeService activationCodeService) {
        this.activationCodeService = activationCodeService;
    }


    @PostMapping("/activationCandidateByMail")
    public Result activationCandidateByMail(@RequestParam int candidateId) throws Exception{
        return activationCodeService.activateCandidateAccountByEmail(candidateId);
    }

    @PostMapping("/activationEmployerByMail")
    public Result activationEmployerByMail(@RequestParam int employerId){
        return activationCodeService.activateEmployerAccountByEmail(employerId);
    }

    @PostMapping("/activationEmployerByEmployee")
    public Result activationEmployerByEmployee(@RequestParam int employerId,@RequestParam int employeeId){
        return activationCodeService.activateEmployerAccountByHrmsPersonal(employerId,employeeId);
    }


}
