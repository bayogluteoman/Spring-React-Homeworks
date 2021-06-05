package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.EducationService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstracts.CandidateRepository;
import kodlamaio.northwind.dataAccess.abstracts.EducationRepository;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.Education;
import kodlamaio.northwind.entities.dto.SortedEducationWithCandidate;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationServiceImplement implements EducationService {
    private final EducationRepository educationRepository;

    public EducationServiceImplement(EducationRepository educationRepository, CandidateRepository candidateRepository) {
        this.educationRepository = educationRepository;
        this.candidateRepository = candidateRepository;
    }

    private final CandidateRepository candidateRepository;




    @Override
    public DataResult<Education> add(Education education, int candidateId) {
        Optional<Candidate> optional =  candidateRepository.findById(candidateId);
        education.setCandidate(optional.get());
        Candidate candidate = optional.get();
        candidate.getEducations().add(education);
        candidateRepository.save(candidate);
        educationRepository.save(education);
        return new SuccessDataResult(education,"Succesfully education information added");
    }

    @Override
    public DataResult<List<SortedEducationWithCandidate>> SortedEducationWithCandidate(int candidateId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "finishDate");
        return new SuccessDataResult<List<SortedEducationWithCandidate>>
                (this.educationRepository.getEducationInformation(candidateId,sort), "All educations listed with sorting descending order.");
    }

    @Override
    public DataResult<List<Education>> SortedEducation(int candidateId) {
        return new SuccessDataResult<List<Education>>
                (this.educationRepository.getAllByCandidateIdOrderByFinishDateDesc(candidateId), "All educations listed with sorting descending order.");
    }
}
