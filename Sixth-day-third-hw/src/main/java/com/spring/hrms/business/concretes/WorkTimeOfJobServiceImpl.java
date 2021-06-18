package com.spring.hrms.business.concretes;

import com.spring.hrms.business.abstracts.WorkTimeOfJobService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.SuccessDataResult;
import com.spring.hrms.dataAccess.abstracts.WorkTimeOfJobRepository;
import com.spring.hrms.entities.concretes.WorkTimeOfJob;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTimeOfJobServiceImpl implements WorkTimeOfJobService {

    private final WorkTimeOfJobRepository workTimeOfJobRepository;

    public WorkTimeOfJobServiceImpl(WorkTimeOfJobRepository workTimeOfJobRepository) {
        this.workTimeOfJobRepository = workTimeOfJobRepository;
    }

    @Override
    public DataResult<WorkTimeOfJob> add(WorkTimeOfJob workTimeOfJob) {
        workTimeOfJobRepository.save(workTimeOfJob);
        return new SuccessDataResult<WorkTimeOfJob>(workTimeOfJob);
    }

    @Override
    public DataResult<List<WorkTimeOfJob>> getAll() {
        return new SuccessDataResult<List<WorkTimeOfJob>>(workTimeOfJobRepository.findAll());
    }
}
