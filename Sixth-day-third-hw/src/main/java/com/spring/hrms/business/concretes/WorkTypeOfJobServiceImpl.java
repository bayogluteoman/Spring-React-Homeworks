package com.spring.hrms.business.concretes;

import com.spring.hrms.business.abstracts.WorkTypeOfJobService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.SuccessDataResult;
import com.spring.hrms.dataAccess.abstracts.WorkTypeOfJobRepository;
import com.spring.hrms.entities.concretes.WorkTimeOfJob;
import com.spring.hrms.entities.concretes.WorkTypeOfJob;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTypeOfJobServiceImpl implements WorkTypeOfJobService {

    private final WorkTypeOfJobRepository workTypeOfJobRepository;

    public WorkTypeOfJobServiceImpl(WorkTypeOfJobRepository workTypeOfJobRepository) {
        this.workTypeOfJobRepository = workTypeOfJobRepository;
    }

    @Override
    public DataResult<WorkTypeOfJob> add(WorkTypeOfJob workTypeOfJob) {
        workTypeOfJobRepository.save(workTypeOfJob);
        return new SuccessDataResult<WorkTypeOfJob>(workTypeOfJob);
    }

    @Override
    public DataResult<List<WorkTypeOfJob>> getAll() {
        return new SuccessDataResult<List<WorkTypeOfJob>>(workTypeOfJobRepository.findAll());
    }
}
