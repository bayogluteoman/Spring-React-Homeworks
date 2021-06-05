package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.CvService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.Cv;
import kodlamaio.northwind.entities.dto.CvDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cv")
public class CvController {

    private final CvService cvService;

    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("/add")
    public DataResult<Cv> add(@RequestParam int candidateId, @RequestBody Cv cv){
        return cvService.add(candidateId,cv);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<CvDto> getByCandidateId(@RequestParam int candidateId){
        return cvService.getByCandidate_Id(candidateId);
    }
}
