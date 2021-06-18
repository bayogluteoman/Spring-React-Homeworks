package com.spring.hrms.adapter.concretes;

import com.spring.hrms.adapter.abstracts.ServiceAdapter;
import com.spring.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class MernisServiceAdapter implements ServiceAdapter {
    @Override
    public boolean checkIfRealPerson(Candidate candidate) throws Exception {
       return true;
    }
}
