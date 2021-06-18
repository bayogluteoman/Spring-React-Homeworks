package com.spring.hrms.dataAccess.abstracts;

import com.spring.hrms.entities.concretes.WorkTypeOfJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTypeOfJobRepository extends JpaRepository<WorkTypeOfJob,Integer> {
}
