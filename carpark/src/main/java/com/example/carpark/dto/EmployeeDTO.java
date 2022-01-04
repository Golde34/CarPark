package com.example.carpark.dto;

import com.example.carpark.constants.RegexValidate;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.Date;
@Data
public class EmployeeDTO {
    @NotBlank(message = "Name is required")
    private String name;

    private Date birthDate;
    private String sex;
    private String address;

    @NotBlank
    private String account;

    @NotBlank(message = "Email is required")
    @Pattern(regexp = RegexValidate.EMAIL_REGEX, message = "Invalid email, form text@gmail.com")
    private String email;

    @NotBlank
    @Pattern(regexp = RegexValidate.PHONE_REGEX, message = "Invalid phone, 10-11 number, start with 03 or 09")
    private String phone;

    @NotBlank
    @Size(min = 6, message = "Password length > 6")
    private String password;

    private String department;
    private Integer id;
}
