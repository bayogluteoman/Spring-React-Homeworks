package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.EducationService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Education;
import kodlamaio.northwind.entities.dto.SortedEducationWithCandidate;
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
    public Result add(@RequestBody Education education, @RequestParam int candidateId){
        return educationService.add(education,candidateId);
    }

    @GetMapping("/getAllByReverseSortGraduate")
    public DataResult<List<SortedEducationWithCandidate>> getAllByReverseSortGraduate(@RequestParam int candidateId){
        return educationService.SortedEducationWithCandidate(candidateId);
    }
}
