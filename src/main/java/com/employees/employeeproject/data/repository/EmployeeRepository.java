package com.employees.employeeproject.data.repository;

import com.employees.employeeproject.data.entity.Employee;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    @Query(value = "select e FROM Employee e WHERE e.id =:id")
    Employee getEmployeeById(@Param("id") Long id);

}
