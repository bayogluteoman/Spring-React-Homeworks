package com.spring.hrms.business.concretes;

import com.spring.hrms.business.abstracts.EducationService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.SuccessDataResult;
import com.spring.hrms.dataAccess.abstracts.CandidateRepository;
import com.spring.hrms.dataAccess.abstracts.EducationRepository;
import com.spring.hrms.entities.concretes.Candidate;
import com.spring.hrms.entities.concretes.Education;
import com.spring.hrms.entities.concretes.JobAdvertisement;
import com.spring.hrms.entities.dto.SortedEducationWithCandidate;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationServiceImpl implements EducationService {
    private final EducationRepository educationRepository;
    private final CandidateRepository candidateRepository;


    public EducationServiceImpl(EducationRepository educationRepository, CandidateRepository candidateRepository) {
        this.educationRepository = educationRepository;
        this.candidateRepository = candidateRepository;
    }

    @Override
    public DataResult<Education> add(Education education,int candidateId) {
        Optional<Candidate> optional =  candidateRepository.findById(candidateId);
        education.setCandidate(optional.get());
        Candidate candidate = optional.get();
        candidate.getEducations().add(education);
        candidateRepository.save(candidate);
        educationRepository.save(education);
        return new SuccessDataResult(education,"Succesfully education information added");
    }


    @Override
    public DataResult<List<SortedEducationWithCandidate>> SortedEducationWithCandidate(int candidateId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "finishDate");
        return new SuccessDataResult<List<SortedEducationWithCandidate>>
                (this.educationRepository.getEducationInformation(candidateId,sort), "All educations listed with sorting descending order.");
    }

    @Override
    public DataResult<List<Education>> SortedEducation(int candidateId) {
        return new SuccessDataResult<List<Education>>
                (this.educationRepository.getAllByCandidateIdOrderByFinishDateDesc(candidateId), "All educations listed with sorting descending order.");
    }
}
