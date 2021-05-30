package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ActivationCodeService;
import kodlamaio.northwind.core.utilities.results.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
