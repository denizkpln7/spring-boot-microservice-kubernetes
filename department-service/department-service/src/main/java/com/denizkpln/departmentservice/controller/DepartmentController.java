package com.denizkpln.departmentservice.controller;

import com.denizkpln.departmentservice.dto.DeportmentDto;
import com.denizkpln.departmentservice.model.Department;
import com.denizkpln.departmentservice.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(DepartmentController.class);

    private final DepartmentService departmentService;

//    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${application.value}")
    String config;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @PostMapping
    public ResponseEntity<Department> add(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return new ResponseEntity<>(departmentService.add(department), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DeportmentDto> findById(@PathVariable("id") Long id) {
        LOGGER.info("Department find: id={}", id);
        return new ResponseEntity<>(departmentService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<Department> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Department find: departmentId={}", departmentId);
        return new ResponseEntity<>(departmentService.findByDepartment(departmentId), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Department>> findAllDepartment() {
        LOGGER.info("Department find: getall={}");
        return new ResponseEntity<>(departmentService.findAllDepartment(), HttpStatus.OK);
    }

    @GetMapping("/config")
    public ResponseEntity<String> findConfig() {
        LOGGER.info("Department find: config={}");
        return new ResponseEntity<>(config, HttpStatus.OK);
    }

//    @PostMapping("/kafka")
//    public ResponseEntity<String> sendKafka(){
//        Department department=new Department();
//        department.setId(1L);
//        department.setName("kafka");
//        String senderMessage = "kafka";
//        kafkaTemplate.send("transfer-notification",  senderMessage);
//        LOGGER.info("Department find: config={}");
//        return new ResponseEntity<>("kafka", HttpStatus.OK);
//    }

}