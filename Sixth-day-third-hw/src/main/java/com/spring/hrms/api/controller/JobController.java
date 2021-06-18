package com.spring.hrms.api.controller;

import com.spring.hrms.business.abstracts.JobService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.entities.concretes.Job;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/getall")
    public DataResult getAll(){
        return jobService.getAll();
    }

    @PostMapping("/add")
    public DataResult add(@RequestBody Job job){
        return jobService.add(job);
    }
}
