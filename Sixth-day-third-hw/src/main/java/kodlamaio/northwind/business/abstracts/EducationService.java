package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.Education;
import kodlamaio.northwind.entities.dto.SortedEducationWithCandidate;

import java.util.List;

public interface EducationService {
    DataResult<Education> add(Education education, int candidateId);
    DataResult<List<SortedEducationWithCandidate>> SortedEducationWithCandidate(int candidateId);
    DataResult<List<Education>> SortedEducation(int candidateId);
}
