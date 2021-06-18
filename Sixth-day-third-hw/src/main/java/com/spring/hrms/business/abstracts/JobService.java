package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.entities.concretes.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {
    DataResult<List<Job>> getAll();
    DataResult add(Job job);
}
