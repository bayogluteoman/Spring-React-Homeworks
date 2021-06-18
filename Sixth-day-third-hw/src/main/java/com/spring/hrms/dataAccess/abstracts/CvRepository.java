package com.spring.hrms.dataAccess.abstracts;

import com.spring.hrms.entities.concretes.Cv;
import com.spring.hrms.entities.dto.CvDto;
import com.spring.hrms.entities.dto.SortedEducationWithCandidate;
import com.spring.hrms.entities.dto.SortedJobExperiencesWithCandidate;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CvRepository extends JpaRepository<Cv,Integer> {
    Cv getByCandidate_Id(int candidateId);

}
