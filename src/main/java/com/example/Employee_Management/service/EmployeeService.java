package com.example.Employee_Management.service;

import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepo EmployeeRepo;

    public EmployeeService(EmployeeRepo EmployeeRepo) {
        this.EmployeeRepo = EmployeeRepo;
    }

    public Employee saveEmployee(Employee employee) {
        return EmployeeRepo.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return EmployeeRepo.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return EmployeeRepo.findAll();
    }

    public void deleteEmployee(Long id) {
        EmployeeRepo.deleteById(id);
    }
}
