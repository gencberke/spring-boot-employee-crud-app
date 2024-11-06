package com.employees.employeeproject.service;

import com.employees.employeeproject.data.dto.EmployeeResponse;
import com.employees.employeeproject.data.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeById(Long id);

    EmployeeResponse signNewEmployee(Employee employee);

    EmployeeResponse updateEmployeeById(Long id, Employee employee);

    void deleteEmployeeById(Long id);
}
