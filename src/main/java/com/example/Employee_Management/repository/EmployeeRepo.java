package com.example.Employee_Management.repository;

import com.example.Employee_Management.entity.EmpPersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmpPersonalDetails, Long> {
}
