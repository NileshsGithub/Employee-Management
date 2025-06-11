package com.example.Employee_Management.controller;

import com.example.Employee_Management.entity.EmpPersonalDetails;
import com.example.Employee_Management.repository.EmployeeRepo;
import com.example.Employee_Management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
       private final EmployeeService employeeService;
    @Autowired
    private EmployeeRepo empRepo;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<EmpPersonalDetails> createEmployee(@RequestBody EmpPersonalDetails employee) {
        if (employee.getAddress() != null) {
            employee.getAddress().setEmployee(employee);
        }
        if (employee.getContact() != null) {
            employee.getContact().setEmployee(employee);
        }

        EmpPersonalDetails saved = empRepo.save(employee);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpPersonalDetails> getEmployee(@PathVariable Long id) {
        EmpPersonalDetails employee = employeeService.getEmployeeById(id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<EmpPersonalDetails>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpPersonalDetails> updateEmployee(
            @PathVariable Long id,
            @RequestBody EmpPersonalDetails updatedEmployee) {

        return empRepo.findById(id).map(employee -> {
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setDOB(updatedEmployee.getDOB());
            return new ResponseEntity<>(empRepo.save(employee), HttpStatus.OK);
        }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
