package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.entities.concretes.Candidate;
import com.spring.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;

@Service
public interface EmployerRegisterService {
    DataResult register(Employer employer) throws Exception;
    boolean checkIfEmployerExistBefore(Employer employer);
    boolean checkNullFields(Employer employer);
}
