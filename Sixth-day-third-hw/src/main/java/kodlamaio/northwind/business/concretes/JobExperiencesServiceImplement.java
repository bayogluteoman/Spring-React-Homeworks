package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.JobExperiencesService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstracts.CandidateRepository;
import kodlamaio.northwind.dataAccess.abstracts.JobExperiencesRepository;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.JobExperiences;
import kodlamaio.northwind.entities.dto.SortedJobExperiencesWithCandidate;
import org.springframework.data.domain.Sort;

import java.util.List;

public class JobExperiencesServiceImplement implements JobExperiencesService {
    public JobExperiencesServiceImplement(JobExperiencesRepository jobExperiencesRepository, CandidateRepository candidateRepository) {
        this.jobExperiencesRepository = jobExperiencesRepository;
        this.candidateRepository = candidateRepository;
    }

    private final JobExperiencesRepository jobExperiencesRepository;
    private final CandidateRepository candidateRepository;

    @Override
    public DataResult<JobExperiences> add(JobExperiences jobExperiences, int candidateId) {
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
