package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.entities.concretes.JobExperiences;
import com.spring.hrms.entities.dto.SortedEducationWithCandidate;
import com.spring.hrms.entities.dto.SortedJobExperiencesWithCandidate;

import java.util.List;

public interface JobExperiencesService {
    DataResult<JobExperiences> add(JobExperiences jobExperiences,int candidateId);
    DataResult<List<SortedJobExperiencesWithCandidate>> SortedJobExperiencesWithCandidate(int candidateId);
    DataResult<List<JobExperiences>> SortedJobExperiences(int candidateId);

}
