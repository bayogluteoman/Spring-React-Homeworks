package com.spring.hrms.api.controller;

import com.spring.hrms.business.abstracts.WorkTimeOfJobService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.entities.concretes.WorkTimeOfJob;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/workTime")
public class WorkTimeOfJobController {

    private final WorkTimeOfJobService workTimeOfJobService;

    public WorkTimeOfJobController(WorkTimeOfJobService workTimeOfJobService) {
        this.workTimeOfJobService = workTimeOfJobService;
    }

    @GetMapping("/getAll")
    public Result getAll(){
        return workTimeOfJobService.getAll();
    }

    @PostMapping("/add")
    public DataResult<WorkTimeOfJob> add(@RequestBody WorkTimeOfJob workTimeOfJob){
        return workTimeOfJobService.add(workTimeOfJob);
    }
}
