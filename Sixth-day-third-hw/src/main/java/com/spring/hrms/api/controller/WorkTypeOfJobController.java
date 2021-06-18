package com.spring.hrms.api.controller;

import com.spring.hrms.business.abstracts.WorkTypeOfJobService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.entities.concretes.WorkTypeOfJob;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("workType")
public class WorkTypeOfJobController {

    private final WorkTypeOfJobService workTypeOfJobService;

    public WorkTypeOfJobController(WorkTypeOfJobService workTypeOfJobService) {
        this.workTypeOfJobService = workTypeOfJobService;
    }
    @GetMapping("/getAll")
    public Result getAll(){
        return workTypeOfJobService.getAll();
    }
    @PostMapping
    public DataResult<WorkTypeOfJob> add(@RequestBody WorkTypeOfJob workTypeOfJob){
        return workTypeOfJobService.add(workTypeOfJob);
    }
}
