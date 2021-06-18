package com.spring.hrms.business.concretes;

import com.spring.hrms.business.abstracts.JobAdvertisementService;
import com.spring.hrms.core.utilities.results.*;
import com.spring.hrms.dataAccess.abstracts.*;
import com.spring.hrms.entities.concretes.JobAdvertisement;
import com.spring.hrms.entities.dto.JobAdvDto;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementServiceImpl implements JobAdvertisementService {
    private final JobAdvertisementRepository jobAdvertisementRepository;
    private final EmployerRepository employerRepository;
    private final CityRepository cityRepository;
    private final JobRepository jobRepository;
    private final WorkTimeOfJobRepository workTimeOfJobRepository;
    private final WorkTypeOfJobRepository workTypeOfJobRepository;

    public JobAdvertisementServiceImpl(JobAdvertisementRepository jobAdvertisementRepository, EmployerRepository employerRepository, CityRepository cityRepository, JobRepository jobRepository, WorkTimeOfJobRepository workTimeOfJobRepository, WorkTypeOfJobRepository workTypeOfJobRepository) {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
        this.cityRepository = cityRepository;
        this.employerRepository = employerRepository;
        this.jobRepository = jobRepository;
        this.workTimeOfJobRepository = workTimeOfJobRepository;
        this.workTypeOfJobRepository = workTypeOfJobRepository;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementRepository.getAllByActivationStatusTrue(), "All active job advertisement are listed..");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementRepository.getAllByActivationStatusTrue(sort), "All active job advertisement are listed with sorting descending order.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByCompanyId(int id) {
        if (!this.employerRepository.existsById(id)) {
            return new ErrorDataResult<List<JobAdvertisement>>("There is no advertisement or company with entered id.");
        }

        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementRepository.getAllByEmployerId(id), "All job advertisement listed with entered id");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByCompanyName(String companyName) {
        if (this.employerRepository.findAllByCompanyName(companyName).isEmpty()) {
            return new ErrorDataResult<List<JobAdvertisement>>("Invalid Company Name");
        }

        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementRepository.getAllByEmployer_CompanyName(companyName), "All job advertisement listed with entered company name");
    }

    @Override
    public DataResult<JobAdvertisement> getByJobAdvertisementId(int jobAdvertisementId) {
        JobAdvertisement jobAdvertisement = jobAdvertisementRepository.findById(jobAdvertisementId).orElse(null);
        return new SuccessDataResult<JobAdvertisement>
                (jobAdvertisement, "Succesfully get job advertisement by id");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllNotActived() {
        return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementRepository.getAllByActivationStatusFalse());
    }


    @Override
    public Result add(JobAdvDto JobAdvDto) {
        JobAdvertisement jobAdvertisementTemp = new JobAdvertisement();
        jobAdvertisementTemp.setJobDescription(JobAdvDto.getJobDescription());
        jobAdvertisementTemp.setActivationStatus(false);
        jobAdvertisementTemp.setId(0);
        jobAdvertisementTemp.setLastApplyDate(JobAdvDto.getLastApplyDate());
        jobAdvertisementTemp.setMinWage(JobAdvDto.getMinWage());
        jobAdvertisementTemp.setMaxWage(JobAdvDto.getMaxWage());
        jobAdvertisementTemp.setNumberOfPosition(JobAdvDto.getNumberOfPosition());
        jobAdvertisementTemp.setPublishDate(JobAdvDto.getPublishDate());
        jobAdvertisementTemp.setWorkTypeOfJobs(workTypeOfJobRepository.findById(JobAdvDto.getWorkTypeId()).get());
        jobAdvertisementTemp.setCity(cityRepository.findById(JobAdvDto.getCityId()).get());
        jobAdvertisementTemp.setEmployer(employerRepository.findById(JobAdvDto.getEmployerId()).get());
        jobAdvertisementTemp.setJob(jobRepository.findById(JobAdvDto.getJobId()).get());
        jobAdvertisementTemp.setWorkTimeOfJobs(workTimeOfJobRepository.findById(JobAdvDto.getWorkTimeId()).get());

        this.jobAdvertisementRepository.save(jobAdvertisementTemp);
        return new SuccessResult("Successfully Added!");

    }

    @Override
    public Result activate(int id, boolean activationStatus) {
        JobAdvertisement jobAdvertisement = this.jobAdvertisementRepository.findById(id).orElse(null);

        jobAdvertisement.setActivationStatus(activationStatus);

        this.jobAdvertisementRepository.save(jobAdvertisement);
        return new SuccessResult("Activation Status is Updated");
    }


    private boolean isCityExist(JobAdvertisement jobAdvertisement) {
        if (this.cityRepository.existsById(jobAdvertisement.getCity().getId())) {
            return true;
        }

        return false;
    }


    private boolean isExistEmployer(JobAdvertisement jobAdvertisement) {
        if (this.employerRepository.existsById(jobAdvertisement.getEmployer().getId())) {
            return true;
        }

        return false;
    }


    private boolean isAllFieldsFilled(JobAdvertisement jobAdvertisement) {
        if (jobAdvertisement.getJobDescription().length() != 0 && jobAdvertisement.getLastApplyDate() != null &&
                jobAdvertisement.getPublishDate() != null) {
            return true;
        }

        return false;
    }

    private boolean isNumberOfPositionDefined(JobAdvertisement jobAdvertisement) {
        if (jobAdvertisement.getNumberOfPosition() > 0) {
            return true;
        }

        return false;
    }
}
