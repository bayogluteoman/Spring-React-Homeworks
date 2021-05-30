package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.JobAdvertisementService;
import kodlamaio.northwind.core.utilities.results.*;
import kodlamaio.northwind.dataAccess.abstratcs.CitiesDao;
import kodlamaio.northwind.dataAccess.abstratcs.EmployerRepository;
import kodlamaio.northwind.dataAccess.abstratcs.JobAdvertisementDao;
import kodlamaio.northwind.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;
    private EmployerRepository employerDao;
    private CitiesDao citiesDao;

    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, EmployerRepository employerDao, CitiesDao citiesDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.employerDao = employerDao;
        this.citiesDao = citiesDao;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.getAllByActivatedTrue(), "All Active Job Advertisements are successfully Listed.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.getAllByActivatedTrue(sort), "All Job Advertisements are Listed in Descending Order!");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByCompanyId(int id) {
        if (!this.employerDao.existsById(id)) {
            return new ErrorDataResult<List<JobAdvertisement>>("Error: Invalid Company / Employer ID!");
        }

        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.getAllByEmployerId(id), "Job Advertisements are Listed for Company ID = " + id);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByCompanyName(String companyName) {
        if (this.employerDao.findAllByCompanyName(companyName).isEmpty()) {
            return new ErrorDataResult<List<JobAdvertisement>>("Error: Invalid Company Name!");
        }

        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.getAllByEmployer_CompanyName(companyName), "Job Advertisements are Listed for Company Name = " + companyName);
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        if (!isAllFieldsFilled(jobAdvertisement)) {
            return new ErrorResult("Error: All fields must be filled!");
        }

        if (!isCityExist(jobAdvertisement)) {
            return new ErrorResult("Error: City is not exist!");
        }

        if (!isExistEmployer(jobAdvertisement)) {
            return new ErrorResult("Error: Employer is not exist!");
        }

        if (!numOfPosition(jobAdvertisement)) {
            return new ErrorResult("Error: You can have minimum 1 quota for your job!");
        }

        if (!isDifferentCreatedAndExpirationDate(jobAdvertisement)) {
            return new ErrorResult("Error: Expiration Date must be later than Creation Date");
        }

        else {
            this.jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult("Successfully Added!");
        }
    }

    @Override
    public Result activate(int id, boolean activationStatus) {
        JobAdvertisement jobAdvertisementToActivate = this.jobAdvertisementDao.findById(id).orElse(null);

        jobAdvertisementToActivate.setActivated(activationStatus);

        this.jobAdvertisementDao.save(jobAdvertisementToActivate);
        return new SuccessResult("Updated: Activation Status is Updated as " + Boolean.toString(activationStatus));
    }


    private boolean isCityExist(JobAdvertisement jobAdvertisement) {
        if (this.citiesDao.existsById(jobAdvertisement.getCities().getId())) {
            return true;
        }

        return false;
    }


    private boolean isExistEmployer(JobAdvertisement jobAdvertisement) {
        if (this.employerDao.existsById(jobAdvertisement.getEmployer().getId())) {
            return true;
        }

        return false;
    }


    private boolean isAllFieldsFilled(JobAdvertisement jobAdvertisement) {
        if (jobAdvertisement.getJobInfo().length() != 0 && jobAdvertisement.getLast_appy_date() != null &&
                jobAdvertisement.getPublishDate() != null) {
            return true;
        }

        return false;
    }

    private boolean numOfPosition(JobAdvertisement jobAdvertisement) {
        if (jobAdvertisement.getNum_of_position() > 0) {
            return true;
        }

        return false;
    }



    private boolean isDifferentCreatedAndExpirationDate(JobAdvertisement jobAdvertisement) {
        if (!jobAdvertisement.getPublishDate().equals(jobAdvertisement.getLast_appy_date())) {
            return true;
        }

        return false;
    }
}
