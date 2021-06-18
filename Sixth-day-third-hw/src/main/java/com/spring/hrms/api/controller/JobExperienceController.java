package com.spring.hrms.api.controller;

import com.spring.hrms.business.abstracts.JobExperiencesService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.entities.concretes.JobExperiences;
import com.spring.hrms.entities.dto.SortedJobExperiencesWithCandidate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobExperiences")
public class JobExperienceController {
    private final JobExperiencesService jobExperiencesService;

    public JobExperienceController(JobExperiencesService jobExperiencesService) {
        this.jobExperiencesService = jobExperiencesService;
    }

    @PostMapping("/add")
    public DataResult<JobExperiences> add(@RequestBody JobExperiences jobExperiences,@RequestParam int candidateId){
        return jobExperiencesService.add(jobExperiences,candidateId);
    }

    @GetMapping("/getAllByReverseSortJobExperience")
    public DataResult<List<SortedJobExperiencesWithCandidate>> getAllByReverseSortGraduate(@RequestParam int candidateId){
        return jobExperiencesService.SortedJobExperiencesWithCandidate(candidateId);
    }

}
