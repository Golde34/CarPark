package com.example.carpark.dto;

import lombok.Data;

import java.util.Date;
@Data
public class EmployeeDTO {
    private String name;
    private Date birthDate;
    private String sex;
    private String address;
    private String account;
    private String phone;
    private String password;
    private String department;
}
