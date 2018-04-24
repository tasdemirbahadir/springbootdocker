package com.btasdemir.dockerdemo.controller;

import com.btasdemir.dockerdemo.domain.dto.EmployeeDto;
import com.btasdemir.dockerdemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getEmployees() {
        return employeeService.getEmployees();
    }

}
