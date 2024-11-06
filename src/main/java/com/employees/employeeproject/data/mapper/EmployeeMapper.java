package com.employees.employeeproject.data.mapper;

import com.employees.employeeproject.EmployeeProjectApplication;
import com.employees.employeeproject.data.dto.EmployeeResponse;
import com.employees.employeeproject.data.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {

    private final EmployeeProjectApplication employeeProjectApplication;

    public EmployeeMapper(EmployeeProjectApplication employeeProjectApplication) {
        this.employeeProjectApplication = employeeProjectApplication;
    }

    public EmployeeResponse toResponse(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setFirstName(employee.getFirstName());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setPhoneNumber(employee.getPhoneNumber());
        return employeeResponse;
    }

    public List<EmployeeResponse> toListResponse(List<Employee> employee) {
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();

//        for (Employee employee1 : employee) {
//            EmployeeResponse employeeResponse = new EmployeeResponse();
//            employeeResponse.setFirstName(employee1.getFirstName());
//            employeeResponse.setLastName(employee1.getLastName());
//            employeeResponse.setEmail(employee1.getEmail());
//            employeeResponse.setPhoneNumber(employee1.getPhoneNumber());
//            employeeResponseList.add(employeeResponse);
//        }

        // Normally, this stream would be written using map()
        employee.stream().
                forEach(employee1 -> {
                EmployeeResponse employeeResponse = new EmployeeResponse();
                            employeeResponse.setFirstName(employee1.getFirstName());
                            employeeResponse.setLastName(employee1.getLastName());
                            employeeResponse.setEmail(employee1.getEmail());
                            employeeResponse.setPhoneNumber(employee1.getPhoneNumber());
                            employeeResponseList.add(employeeResponse);
                        }
                );

        return employeeResponseList;
    }

}
