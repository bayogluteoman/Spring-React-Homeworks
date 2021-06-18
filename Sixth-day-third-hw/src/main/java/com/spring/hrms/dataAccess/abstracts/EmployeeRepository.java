package com.spring.hrms.dataAccess.abstracts;

import com.spring.hrms.entities.concretes.Employee;
import com.spring.hrms.entities.concretes.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
