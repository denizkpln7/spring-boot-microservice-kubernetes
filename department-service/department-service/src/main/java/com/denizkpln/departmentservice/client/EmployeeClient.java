package com.denizkpln.departmentservice.client;

import com.denizkpln.departmentservice.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "employee-service", path = "/employee")
public interface EmployeeClient {

    @GetMapping("/{id}")
    ResponseEntity<Employee> findById(@PathVariable("id") Long id);
}
