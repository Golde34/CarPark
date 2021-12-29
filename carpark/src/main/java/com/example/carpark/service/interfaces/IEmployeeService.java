package com.example.carpark.service.interfaces;

import com.example.carpark.dto.EmployeeDTO;
import com.example.carpark.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee saveEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> displayEmployees();
}
