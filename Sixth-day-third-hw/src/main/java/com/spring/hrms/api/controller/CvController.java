package com.spring.hrms.api.controller;

import com.spring.hrms.business.abstracts.CvService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.dataAccess.abstracts.CvRepository;
import com.spring.hrms.entities.concretes.Cv;
import com.spring.hrms.entities.dto.CvDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cv")
public class CvController {

    private final CvService cvService;

    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("/add")
    public DataResult<Cv> add(@RequestParam int candidateId,@RequestBody Cv cv){
        return cvService.add(candidateId,cv);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<CvDto> getByCandidateId(@RequestParam int candidateId){
        return cvService.getByCandidate_Id(candidateId);
    }
}
