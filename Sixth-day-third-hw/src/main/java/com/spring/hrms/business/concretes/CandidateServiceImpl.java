package com.spring.hrms.business.concretes;

import com.spring.hrms.adapter.concretes.MernisServiceAdapter;
import com.spring.hrms.business.abstracts.CandidateService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.SuccessDataResult;
import com.spring.hrms.dataAccess.abstracts.CandidateRepository;
import com.spring.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public DataResult<Candidate> getAll() {
        return new SuccessDataResult<List<Candidate>>(candidateRepository.findAll(),"Listed candidates.");
    }

    @Override
    public DataResult add(Candidate candidate) {
        candidateRepository.save(candidate);
        return new SuccessDataResult(candidate,"The candidate added.");
    }

    @Override
    public DataResult delete(int candidateId) {
        candidateRepository.deleteById(candidateId);
        return new SuccessDataResult(candidateId,"Succesfuly deleted");
    }


}
