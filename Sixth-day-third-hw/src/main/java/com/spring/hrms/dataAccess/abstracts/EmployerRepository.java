package com.spring.hrms.dataAccess.abstracts;

import com.spring.hrms.entities.concretes.Employer;
import com.spring.hrms.entities.concretes.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface EmployerRepository extends JpaRepository<Employer,Integer> {

    List<Employer> findAllByCompanyName(String companyName);

    boolean existsById(int id);
}
