package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.JobExperiences;
import kodlamaio.northwind.entities.dto.SortedJobExperiencesWithCandidate;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobExperiencesService {
    DataResult<JobExperiences> add(JobExperiences jobExperiences, int candidateId);
    DataResult<List<SortedJobExperiencesWithCandidate>> SortedJobExperiencesWithCandidate(int candidateId);
    DataResult<List<JobExperiences>> SortedJobExperiences(int candidateId);
}
