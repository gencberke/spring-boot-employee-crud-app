package com.employees.employeeproject.controller;

import com.employees.employeeproject.data.dto.EmployeeResponse;
import com.employees.employeeproject.data.entity.Employee;
import com.employees.employeeproject.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public EmployeeResponse getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    //todo create update and delete metods

    //create method
    @PostMapping("/employee")
    public EmployeeResponse signEmployee(@RequestBody Employee employee) {
        return employeeService.signNewEmployee(employee);
    }

    //update method
    @PutMapping("/employee")
    public EmployeeResponse updateEmployee(@RequestParam Long id, @RequestBody Employee employee ) {
        return employeeService.updateEmployeeById(id, employee);
    }

    //delete method
    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployeeById(id);
    }

    //gathers all employees to EmployeeResponse type
    @GetMapping("/employees")
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
