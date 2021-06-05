package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.JobService;
import kodlamaio.northwind.core.utilities.results.*;
import kodlamaio.northwind.dataAccess.abstracts.JobDao;
import kodlamaio.northwind.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobManager implements JobService {

    private JobDao jobDao;

    @Autowired
    public JobManager(JobDao jobDao) {
        super();
        this.jobDao = jobDao;
    }

    @Override
    public DataResult<List<Job>> getAll() {
        return new SuccessDataResult<List<Job>>
                (this.jobDao.findAll(),"Data listed");

    }

    @Override
    public DataResult add(Job job) {
        List<Job> jobList = jobDao.findAll();
        for (Job job1 : jobList){
            if (job1.getJobTitle().equals(job.getJobTitle())){
                return new ErrorDataResult(job, "Job has already been added before.");
            }
        }
        jobDao.save(job);
        return new SuccessDataResult(job,"The job added.");
    }
}
