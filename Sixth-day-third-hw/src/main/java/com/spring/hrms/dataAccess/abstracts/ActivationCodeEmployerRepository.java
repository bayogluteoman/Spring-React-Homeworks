package com.spring.hrms.dataAccess.abstracts;

import com.spring.hrms.entities.concretes.ActivationCodeCandidate;
import com.spring.hrms.entities.concretes.ActivationCodeEmployer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivationCodeEmployerRepository extends JpaRepository<ActivationCodeEmployer,Integer> {
}
