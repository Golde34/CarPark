package com.example.carpark.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account")
    private String account;

    @Column(name = "department")
    private String department;

    @Column(name = "employee_address")
    private String address;

    @Column(name = "employee_birthdate")
    private Date birthdate;

    @Column(name = "employee_email")
    private String email;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "sex")
    private String sex;
}
