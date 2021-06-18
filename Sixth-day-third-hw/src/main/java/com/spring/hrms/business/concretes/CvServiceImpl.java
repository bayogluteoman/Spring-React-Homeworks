package com.spring.hrms.business.concretes;

import com.spring.hrms.business.abstracts.CvService;
import com.spring.hrms.business.abstracts.EducationService;
import com.spring.hrms.business.abstracts.JobExperiencesService;
import com.spring.hrms.business.abstracts.JobService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.SuccessDataResult;
import com.spring.hrms.dataAccess.abstracts.*;
import com.spring.hrms.entities.concretes.Candidate;
import com.spring.hrms.entities.concretes.Cv;
import com.spring.hrms.entities.dto.CvDto;
import org.springframework.stereotype.Service;

@Service
public class CvServiceImpl implements CvService {

    private final CvRepository cvRepository;
    private final CandidateRepository candidateRepository;
    private final JobExperiencesService jobExperiencesService;
    private final EducationService educationService;


    public CvServiceImpl(CvRepository cvRepository, CandidateRepository candidateRepository, JobExperiencesService jobExperiencesService, EducationService educationService) {
        this.cvRepository = cvRepository;
        this.candidateRepository = candidateRepository;
        this.jobExperiencesService = jobExperiencesService;
        this.educationService = educationService;
    }

    @Override
    public DataResult<Cv> add(int candidateId, Cv cv) {
        Candidate candidate = candidateRepository.findById(candidateId).get();
        candidate.setCv(cv);
        candidateRepository.save(candidate);
        cv.setCandidate(candidate);
        cvRepository.save(cv);
        return new SuccessDataResult(cv,"Succesfuly added CV to system.");
    }

    @Override
    public DataResult<CvDto> getByCandidate_Id(int id) {
        Candidate candidate = candidateRepository.findById(id).get();

        CvDto cvDto = new CvDto();
        cvDto.setCoverLetter(candidate.getCv().getCoverLetter());
        cvDto.setDescription(candidate.getCv().getDescription());
        cvDto.setGithubAddress(candidate.getCv().getGithubAddress());
        cvDto.setLinkedinAddress(candidate.getCv().getLinkedinAddress());
        cvDto.setTechnologies(candidate.getCv().getTechnologies());
        cvDto.setCandidate(candidate);
        cvDto.setJobExperiences(jobExperiencesService.SortedJobExperiences(id).getData());
        cvDto.setEducationList(educationService.SortedEducation(id).getData());
        cvDto.setLanguageList(candidate.getLanguage());
        return new SuccessDataResult(cvDto);
    }
}
