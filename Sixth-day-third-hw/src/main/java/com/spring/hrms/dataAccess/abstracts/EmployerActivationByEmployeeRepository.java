package com.spring.hrms.dataAccess.abstracts;

import com.spring.hrms.entities.concretes.EmployerActivationByEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerActivationByEmployeeRepository extends JpaRepository<EmployerActivationByEmployee,Integer> {
}
