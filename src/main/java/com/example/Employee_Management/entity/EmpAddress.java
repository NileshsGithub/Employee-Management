package com.example.Employee_Management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "employee_address")
public class EmpAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lane1;
    private String lane2;
    private String city;
    private String country;
    private String zipcode;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "empId")
    private EmpPersonalDetails employee;

}
