package com.spring.hrms.adapter.abstracts;

import com.spring.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public interface ServiceAdapter {
    public boolean checkIfRealPerson(Candidate candidate) throws Exception;
}
