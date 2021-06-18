package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.entities.concretes.JobAdvertisement;
import com.spring.hrms.entities.concretes.WorkTimeOfJob;

import java.util.List;

public interface WorkTimeOfJobService {
    DataResult<WorkTimeOfJob> add(WorkTimeOfJob workTimeOfJob);
    DataResult<List<WorkTimeOfJob>> getAll();

}
