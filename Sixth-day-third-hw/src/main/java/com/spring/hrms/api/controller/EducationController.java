package com.spring.hrms.api.controller;

import com.spring.hrms.business.abstracts.EducationService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.entities.concretes.Education;
import com.spring.hrms.entities.dto.SortedEducationWithCandidate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationController {
    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Education education,@RequestParam int candidateId){
        return educationService.add(education,candidateId);
    }

    @GetMapping("/getAllByReverseSortGraduate")
    public DataResult<List<SortedEducationWithCandidate>> getAllByReverseSortGraduate(@RequestParam int candidateId){
        return educationService.SortedEducationWithCandidate(candidateId);
    }
}
