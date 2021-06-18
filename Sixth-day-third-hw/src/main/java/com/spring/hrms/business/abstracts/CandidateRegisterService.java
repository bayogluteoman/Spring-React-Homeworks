package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.entities.abstracts.User;
import com.spring.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public interface CandidateRegisterService {
    DataResult register(Candidate candidate) throws Exception;
    boolean checkIfUserExistBefore(Candidate candidate);
    boolean checkCanditateIfRealPerson(Candidate candidate) throws Exception;
}
