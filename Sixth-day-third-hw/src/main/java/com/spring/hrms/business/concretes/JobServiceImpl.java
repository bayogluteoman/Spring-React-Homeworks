package com.spring.hrms.business.concretes;

import com.spring.hrms.business.abstracts.JobService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.ErrorDataResult;
import com.spring.hrms.core.utilities.results.SuccessDataResult;
import com.spring.hrms.dataAccess.abstracts.JobRepository;
import com.spring.hrms.entities.concretes.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public DataResult<List<Job>> getAll() {
        return new SuccessDataResult<List<Job>>(jobRepository.findAll(),"Data listed");
    }

    @Override
    public DataResult add(Job job) {
        List<Job> jobList = jobRepository.findAll();
        for (Job job1 : jobList){
            if (job1.getPosition().equals(job.getPosition())){
                return new ErrorDataResult(job, "Job has already been added before.");
            }
        }
        jobRepository.save(job);
        return new SuccessDataResult(job,"The job added.");
    }
}
