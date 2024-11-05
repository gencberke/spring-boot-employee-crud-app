package com.employees.employeeproject.controller;

import com.employees.employeeproject.data.dto.EmployeeResponse;
import com.employees.employeeproject.data.entity.Employee;
import com.employees.employeeproject.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public EmployeeResponse getEmployee(@RequestParam(value = "id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    //todo create update and delete metods

    //create method
    @PostMapping
    public EmployeeResponse signEmployee(@RequestBody Employee employee) {
        return employeeService.signNewEmployee(employee);
    }

    //update method
    @PutMapping("/{id}")
    public EmployeeResponse updateEmployee(@PathVariable Long id, @RequestBody Employee employee ) {
        return employeeService.updateEmployeeById(id, employee);
    }

    //delete method
    @DeleteMapping
    public void deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployeeById(id);
    }
}
