package com.denizkpln.departmentservice.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne()
    @JoinColumn(name="department_id")
    private Department department;

    private String name;
    private int age;
    private String position;
}
