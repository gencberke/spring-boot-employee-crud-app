package com.employees.employeeproject.data.mapper;

import com.employees.employeeproject.data.dto.EmployeeResponse;
import com.employees.employeeproject.data.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeResponse toResponse(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setFirstName(employee.getFirstName());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setPhoneNumber(employee.getPhoneNumber());
        return employeeResponse;
    }

}
