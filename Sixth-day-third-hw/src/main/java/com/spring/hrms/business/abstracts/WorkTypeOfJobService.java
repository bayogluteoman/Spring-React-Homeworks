package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.entities.concretes.JobAdvertisement;
import com.spring.hrms.entities.concretes.WorkTypeOfJob;

import java.util.List;

public interface WorkTypeOfJobService {
    DataResult<WorkTypeOfJob> add(WorkTypeOfJob workTypeOfJob);
    DataResult<List<WorkTypeOfJob>> getAll();

}
