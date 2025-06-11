package com.example.Employee_Management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "employee")
public class EmpPersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String firstName;
    private String lastName;
    private Date DOB;

    // One-to-One with Address
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private EmpAddress address;

    // One-to-One with Contact
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private EmpContactDetails contact;

}
