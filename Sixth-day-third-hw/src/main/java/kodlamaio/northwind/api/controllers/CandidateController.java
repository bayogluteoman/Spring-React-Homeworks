package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.CandidateRegisterService;
import kodlamaio.northwind.business.abstracts.CandidateService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Candidate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
    private final CandidateService candidateService;
    private final CandidateRegisterService candidateRegisterService;

    public CandidateController(CandidateService candidateService, CandidateRegisterService candidateRegisterService) {
        this.candidateService = candidateService;
        this.candidateRegisterService = candidateRegisterService;
    }

    @GetMapping("/getall")
    public DataResult getAll(){
        return candidateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Candidate candidate) throws Exception {
        return candidateRegisterService.register(candidate);
    }

}
