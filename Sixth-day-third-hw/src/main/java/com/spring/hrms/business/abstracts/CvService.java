package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.entities.concretes.Cv;
import com.spring.hrms.entities.dto.CvDto;

public interface CvService {
    DataResult<Cv> add(int candidateId, Cv cv);

    DataResult<CvDto> getByCandidate_Id(int id);
}
