package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.JobAdvertisement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getAllSorted();
    DataResult<List<JobAdvertisement>> getAllByCompanyId(int id);
    DataResult<List<JobAdvertisement>> getAllByCompanyName(String companyName);

    Result add(JobAdvertisement jobAdvertisement);
    Result activate(int id, boolean activationStatus);
}
