package com.example.carpark.service;

import com.example.carpark.dto.EmployeeDTO;
import com.example.carpark.entities.Employee;
import com.example.carpark.repo.EmployeeRepository;
import com.example.carpark.service.interfaces.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;
    ModelMapper mapper = new ModelMapper();
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Employee emp = mapper.map(employeeDTO, Employee.class);
        employeeRepository.save(emp);
        return emp;
    }

    @Transactional
    public List<EmployeeDTO> displayEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDTO> list = new ArrayList<>();
        for (Employee employee:employeeList) {
            EmployeeDTO employeeDTO = mapper.map(employee, EmployeeDTO.class);
            list.add(employeeDTO);
        }
        return list;
    }
}
