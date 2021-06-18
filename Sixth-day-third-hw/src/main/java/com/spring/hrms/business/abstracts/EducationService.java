package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.entities.concretes.Education;
import com.spring.hrms.entities.dto.SortedEducationWithCandidate;
import org.springframework.data.domain.Sort;

import javax.xml.crypto.Data;
import java.util.List;

public interface EducationService {
    DataResult<Education> add(Education education,int candidateId);
    DataResult<List<SortedEducationWithCandidate>> SortedEducationWithCandidate(int candidateId);
    DataResult<List<Education>> SortedEducation(int candidateId);


}
