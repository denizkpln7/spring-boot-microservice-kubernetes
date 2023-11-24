package com.denizkpln.departmentservice.service;

import com.denizkpln.departmentservice.client.EmployeeClient;
import com.denizkpln.departmentservice.dto.DeportmentDto;
import com.denizkpln.departmentservice.exception.CustomException;
import com.denizkpln.departmentservice.model.Department;
import com.denizkpln.departmentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeClient employeeClient) {
        this.departmentRepository = departmentRepository;
        this.employeeClient = employeeClient;
    }


    public Department add(Department department) {
        return departmentRepository.save(department);
    }



    public DeportmentDto findById(Long id) {
       Department department=departmentRepository.findById(id).orElseThrow(()->new CustomException("Order not found for the order Id:" + id,
                "NOT_FOUND",
                404));

       DeportmentDto deportmentDto=new DeportmentDto(department.getId(),department.getName(),
               department.getEmployeeList()
                       .stream()
                       .map(employee ->employeeClient.findById(employee).getBody())
                       .collect(Collectors.toList()));
        return deportmentDto;
    }

    public Department findByDepartment(Long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow(()->new CustomException("Order not found for the order Id:" + departmentId,
                "NOT_FOUND",
                404));
    }

    public List<Department> findAllDepartment() {
        return  departmentRepository.findAll();
    }
}
