package com.spring.hrms.business.concretes;

import com.spring.hrms.business.abstracts.JobExperiencesService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.SuccessDataResult;
import com.spring.hrms.dataAccess.abstracts.CandidateRepository;
import com.spring.hrms.dataAccess.abstracts.JobExperiencesRepository;
import com.spring.hrms.entities.concretes.Candidate;
import com.spring.hrms.entities.concretes.JobExperiences;
import com.spring.hrms.entities.dto.SortedEducationWithCandidate;
import com.spring.hrms.entities.dto.SortedJobExperiencesWithCandidate;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobExperiencesServiceImpl implements JobExperiencesService {

    private final JobExperiencesRepository jobExperiencesRepository;
    private final CandidateRepository candidateRepository;

    public JobExperiencesServiceImpl(JobExperiencesRepository jobExperiencesRepository, CandidateRepository candidateRepository) {
        this.jobExperiencesRepository = jobExperiencesRepository;
        this.candidateRepository = candidateRepository;
    }

    @Override
    public DataResult<JobExperiences> add(JobExperiences jobExperiences,int candidateId) {
        Candidate candidate = candidateRepository.findById(candidateId).get();
        jobExperiences.setCandidate(candidate);
        candidate.getJobExperiences().add(jobExperiences);
        candidateRepository.save(candidate);
        jobExperiencesRepository.save(jobExperiences);
        return new SuccessDataResult(jobExperiences,"Succesfully added to the system.");
    }

    @Override
    public DataResult<List<SortedJobExperiencesWithCandidate>> SortedJobExperiencesWithCandidate(int candidateId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "finishYear");
        return new SuccessDataResult<List<SortedJobExperiencesWithCandidate>>
                (this.jobExperiencesRepository.getSortedJobExperienceInformation(candidateId,sort), "All educations listed with sorting descending order.");

    }

    @Override
    public DataResult<List<JobExperiences>> SortedJobExperiences(int candidateId) {
        return new SuccessDataResult<List<JobExperiences>>
                (this.jobExperiencesRepository.getAllByCandidateIdOrderByFinishYearDesc(candidateId), "All educations listed with sorting descending order.");

    }
}
