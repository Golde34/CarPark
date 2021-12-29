package com.example.carpark.controllers;

import com.example.carpark.dto.EmployeeDTO;
import com.example.carpark.entities.Employee;
import com.example.carpark.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employeeController")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employeeResponse = employeeService.saveEmployee(employeeDTO);
        return employeeResponse;
    }

    @RequestMapping(value = "/displayEmployee", method = RequestMethod.GET)
    public List<EmployeeDTO> displayEmployee() {
        List<EmployeeDTO> listEmployeeResponse = employeeService.displayEmployees();
        return listEmployeeResponse;
    }
}