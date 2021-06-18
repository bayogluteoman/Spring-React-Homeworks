package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.entities.concretes.Image;

import java.util.List;

public interface ImageService {
    Result add(Image image);
    DataResult<List<Image>> getByCandidateId(int candidateId);
}
