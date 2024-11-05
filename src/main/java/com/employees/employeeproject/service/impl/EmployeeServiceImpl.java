package com.employees.employeeproject.service.impl;

import com.employees.employeeproject.data.dto.EmployeeResponse;
import com.employees.employeeproject.data.entity.Employee;
import com.employees.employeeproject.data.mapper.EmployeeMapper;
import com.employees.employeeproject.data.repository.EmployeeRepository;
import com.employees.employeeproject.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.getEmployeeById(id);
        return employeeMapper.toResponse(employee);
    }

    @Transactional
    @Override
    public EmployeeResponse signNewEmployee(Employee employee) {

       List<Employee> employees = employeeRepository.findAll();
//
//        for (Employee employeeT : employees) {
//            if (employeeT.getLastName().equals(employee.getLastName()) ||
//                    employeeT.getEmail().equals(employee.getEmail()) ||
//                    employeeT.getPhoneNumber().equals(employee.getPhoneNumber()))
//                throw new RuntimeException("this employee has already exists! ");
//        }

        employees.forEach(employeeT -> {
            if (employeeT.getLastName().equals(employee.getLastName()) ||
                    employeeT.getEmail().equals(employee.getEmail()) ||
                    employeeT.getPhoneNumber().equals(employee.getPhoneNumber())) {
                throw new RuntimeException("This employee already exists!");
            }
        });

        employeeRepository.saveAndFlush(employee);
        return employeeMapper.toResponse(employee);
    }

    @Override
    public EmployeeResponse updateEmployeeById(Long id, Employee employee) {
        Employee dbEmployee = employeeRepository.getEmployeeById(id);

        // normalde builder kullanabiliriz.
        dbEmployee.setFirstName(employee.getFirstName());
        dbEmployee.setLastName(employee.getLastName());
        dbEmployee.setEmail(employee.getEmail());
        dbEmployee.setPhoneNumber(employee.getPhoneNumber());
        dbEmployee.setIdentityNumber(employee.getPhoneNumber());

        employeeRepository.save(dbEmployee);

        return employeeMapper.toResponse(dbEmployee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

}






