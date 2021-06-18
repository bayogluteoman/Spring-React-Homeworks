package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.entities.concretes.JobAdvertisement;
import com.spring.hrms.entities.dto.JobAdvDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getAllSorted();
    DataResult<List<JobAdvertisement>> getAllByCompanyId(int id);
    DataResult<List<JobAdvertisement>> getAllByCompanyName(String companyName);
    DataResult<JobAdvertisement> getByJobAdvertisementId(int jobAdvertisementId);
    DataResult<List<JobAdvertisement>> getAllNotActived();

    Result add(JobAdvDto JobAdvDto);
    Result activate(int id, boolean activationStatus);
}
