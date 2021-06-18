package com.spring.hrms.dataAccess.abstracts;

import com.spring.hrms.entities.concretes.WorkTimeOfJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTimeOfJobRepository extends JpaRepository<WorkTimeOfJob,Integer> {
}
