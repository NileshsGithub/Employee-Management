package com.example.Employee_Management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lane1;
    private String lane2;
    private String city;
    private String country;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "empId")
    private Employee employee;

    // Getters and Setters
}
