package com.example.Employee_Management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_contact")
public class EmpContactDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mobileNo;
    private String email;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "empId")
    private EmpPersonalDetails employee;
}
