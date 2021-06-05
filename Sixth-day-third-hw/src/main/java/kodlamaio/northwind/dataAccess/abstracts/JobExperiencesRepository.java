package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.JobExperiences;
import kodlamaio.northwind.entities.dto.SortedJobExperiencesWithCandidate;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobExperiencesRepository extends JpaRepository<JobExperiences,Integer> {
    @Query("Select new kodlamaio.northwind.entities.dto.SortedJobExperiencesWithCandidate(c.id, p.firstName,p.lastName,c.job.name,c.job.jobTitle,c.startYear,c.finishYear) " +
            "from JobExperiences c inner join c.candidate p where c.candidate.id = :candidateId")
    List<SortedJobExperiencesWithCandidate> getSortedJobExperienceInformation(int candidateId, Sort sort);

    List<JobExperiences> getAllByCandidateIdOrderByFinishYearDesc(int candidateId);
}
