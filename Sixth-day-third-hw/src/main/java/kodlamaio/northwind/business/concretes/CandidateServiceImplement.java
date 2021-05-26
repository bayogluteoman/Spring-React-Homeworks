package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.CandidateService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstratcs.CandidateRepository;
import kodlamaio.northwind.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImplement implements CandidateService {
    private final CandidateRepository candidateRepository;

    public CandidateServiceImplement(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public SuccessDataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(candidateRepository.findAll(), "Listed candidates.");
    }

    @Override
    public DataResult add(Candidate candidate) {
        candidateRepository.save(candidate);
        return new SuccessDataResult(candidate,"The candidate added.");

    }
}
