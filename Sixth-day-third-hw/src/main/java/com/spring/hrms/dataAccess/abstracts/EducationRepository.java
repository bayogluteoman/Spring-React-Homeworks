package com.spring.hrms.dataAccess.abstracts;

import com.spring.hrms.entities.concretes.Education;
import com.spring.hrms.entities.concretes.JobAdvertisement;
import com.spring.hrms.entities.concretes.JobExperiences;
import com.spring.hrms.entities.dto.SortedEducationWithCandidate;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EducationRepository extends JpaRepository<Education,Integer> {
    @Query("Select new com.spring.hrms.entities.dto.SortedEducationWithCandidate(c.id, p.firstName,p.lastName,c.schoolName,c.finishDate) " +
            "from Education c inner join c.candidate p where c.candidate.id = :candidateId")
    List<SortedEducationWithCandidate> getEducationInformation(int candidateId,Sort sort);

    List<Education> getAllByCandidateIdOrderByFinishDateDesc(int candidateId);



}
