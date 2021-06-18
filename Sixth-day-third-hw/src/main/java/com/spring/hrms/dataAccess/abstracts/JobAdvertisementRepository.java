package com.spring.hrms.dataAccess.abstracts;

import com.spring.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> getAllByActivationStatusTrue();
    List<JobAdvertisement> getAllByActivationStatusTrue(Sort sort);
    List<JobAdvertisement> getAllByEmployerId(int id);
    List<JobAdvertisement> getAllByEmployer_CompanyName(String companyName);
    List<JobAdvertisement> getAllByActivationStatusFalse();

}
