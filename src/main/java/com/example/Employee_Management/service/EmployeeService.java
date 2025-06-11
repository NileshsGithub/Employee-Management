package com.example.Employee_Management.service;

import com.example.Employee_Management.entity.EmpPersonalDetails;
import com.example.Employee_Management.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepo EmployeeRepo;

    public EmployeeService(EmployeeRepo EmployeeRepo) {
        this.EmployeeRepo = EmployeeRepo;
    }

    public EmpPersonalDetails saveEmployee(EmpPersonalDetails employee) {
        return EmployeeRepo.save(employee);
    }

    public EmpPersonalDetails getEmployeeById(Long id) {
        return EmployeeRepo.findById(id).orElse(null);
    }

    public List<EmpPersonalDetails> getAllEmployees() {
        return EmployeeRepo.findAll();
    }

    public void deleteEmployee(Long id) {
        Optional<EmpPersonalDetails> emp = EmployeeRepo.findById(id);
        emp.ifPresent(EmployeeRepo::delete); // this uses cascading
    }
}
