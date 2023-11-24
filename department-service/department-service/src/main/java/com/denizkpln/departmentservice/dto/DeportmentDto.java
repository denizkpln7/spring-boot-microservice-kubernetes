package com.denizkpln.departmentservice.dto;

import com.denizkpln.departmentservice.model.Employee;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeportmentDto {

    private Long id;

    private String name;

    private List<Employee> employeeList=new ArrayList<>();

}
