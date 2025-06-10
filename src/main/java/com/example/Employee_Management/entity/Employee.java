package com.example.Employee_Management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String firstName;
    private String lastName;
    private Date DOB;

    // One-to-One with Address
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Address address;

    // One-to-One with Contact
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Contact contact;

    // Getters and Setters
}
