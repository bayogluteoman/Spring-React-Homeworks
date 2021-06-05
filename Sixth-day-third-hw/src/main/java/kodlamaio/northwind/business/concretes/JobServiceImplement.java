package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.JobService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstracts.JobRepository;
import kodlamaio.northwind.entities.concretes.Job;

import java.util.List;

public class JobServiceImplement implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImplement(JobRepository jobRepository) {
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
            if (job1.getJobTitle().equals(job.getJobTitle())){
                return new ErrorDataResult(job, "Job has already been added before.");
            }
        }
        jobRepository.save(job);
        return new SuccessDataResult(job,"The job added.");
    }
}
