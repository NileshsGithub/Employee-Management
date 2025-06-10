package com.example.Employee_Management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mobileNo;
    private String email;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "empId")
    private Employee employee;

    // Getters and Setters
}
