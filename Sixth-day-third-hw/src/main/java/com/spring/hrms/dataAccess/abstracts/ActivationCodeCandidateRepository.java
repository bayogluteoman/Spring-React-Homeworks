package com.spring.hrms.dataAccess.abstracts;

import com.spring.hrms.entities.concretes.ActivationCodeCandidate;
import com.spring.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ActivationCodeCandidateRepository extends JpaRepository<ActivationCodeCandidate,Integer> {
}
