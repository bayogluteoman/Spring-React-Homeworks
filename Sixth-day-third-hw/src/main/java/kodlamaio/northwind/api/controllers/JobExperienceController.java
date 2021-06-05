package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.JobExperiencesService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.JobExperiences;
import kodlamaio.northwind.entities.dto.SortedJobExperiencesWithCandidate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobExperiences")
public class JobExperienceController {
    public JobExperienceController(JobExperiencesService jobExperiencesService) {
        this.jobExperiencesService = jobExperiencesService;
    }

    private final JobExperiencesService jobExperiencesService;



    @PostMapping("/add")
    public DataResult<JobExperiences> add(@RequestBody JobExperiences jobExperiences, @RequestParam int candidateId){
        return jobExperiencesService.add(jobExperiences,candidateId);
    }

    @GetMapping("/getAllByReverseSortJobExperience")
    public DataResult<List<SortedJobExperiencesWithCandidate>> getAllByReverseSortGraduate(@RequestParam int candidateId){
        return jobExperiencesService.SortedJobExperiencesWithCandidate(candidateId);
    }

}
