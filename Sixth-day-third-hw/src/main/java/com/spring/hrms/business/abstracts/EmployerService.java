package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployerService {
    DataResult<List<Employer>> getAll();
    void validate(Employer employer);

}
