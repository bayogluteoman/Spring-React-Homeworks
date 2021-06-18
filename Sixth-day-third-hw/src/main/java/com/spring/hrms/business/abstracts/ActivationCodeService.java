package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.entities.abstracts.ActivationCodes;
import com.spring.hrms.entities.abstracts.User;
import com.spring.hrms.entities.concretes.*;
import org.springframework.stereotype.Service;

@Service
public interface ActivationCodeService {
    DataResult activateCandidateAccountByEmail(int candidateId);
    DataResult activateEmployerAccountByEmail(int employerId);
    DataResult activateEmployerAccountByHrmsPersonal(int employerId, int employeeId);
}
