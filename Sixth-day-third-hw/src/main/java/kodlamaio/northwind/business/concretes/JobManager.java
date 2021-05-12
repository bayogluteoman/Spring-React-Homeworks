package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.JobService;
import kodlamaio.northwind.dataAccess.abstratcs.JobDao;
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
    public List<Job> getAll() {
        return this.jobDao.findAll();
    }
}
