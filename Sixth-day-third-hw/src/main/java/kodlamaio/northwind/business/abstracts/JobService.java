package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.entities.concretes.Job;

import java.util.List;

public interface JobService {
    List<Job> getAll();
}
