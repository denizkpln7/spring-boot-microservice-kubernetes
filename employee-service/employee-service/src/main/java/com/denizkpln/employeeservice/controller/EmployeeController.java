package com.denizkpln.employeeservice.controller;


import com.denizkpln.employeeservice.model.Employee;
import com.denizkpln.employeeservice.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(EmployeeController.class);
    
   private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> add(@RequestBody Employee employee) {
        LOGGER.info("Employee add: {}", employee);
        return new ResponseEntity<>(employeeService.add(employee), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        LOGGER.info("Employee find");
        return  new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long id) {
        LOGGER.info("Employee find: id={}", id);
        return  new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<Employee>> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Employee find: departmentId={}", departmentId);
        return new ResponseEntity<>(employeeService.findByDepartment(departmentId), HttpStatus.OK);
    }

}