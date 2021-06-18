package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CandidateService {
    DataResult<Candidate> getAll();
    DataResult add(Candidate candidate);
    DataResult delete(int candidateId);


}
