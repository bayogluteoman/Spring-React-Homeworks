package com.spring.hrms.dataAccess.abstracts;

import com.spring.hrms.entities.concretes.JobExperiences;
import com.spring.hrms.entities.dto.SortedEducationWithCandidate;
import com.spring.hrms.entities.dto.SortedJobExperiencesWithCandidate;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobExperiencesRepository extends JpaRepository<JobExperiences,Integer> {
    @Query("Select new com.spring.hrms.entities.dto.SortedJobExperiencesWithCandidate(c.id, p.firstName,p.lastName,c.job.name,c.job.position,c.startYear,c.finishYear) " +
            "from JobExperiences c inner join c.candidate p where c.candidate.id = :candidateId")
    List<SortedJobExperiencesWithCandidate> getSortedJobExperienceInformation(int candidateId, Sort sort);

    List<JobExperiences> getAllByCandidateIdOrderByFinishYearDesc(int candidateId);


}
