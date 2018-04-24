package com.btasdemir.dockerdemo.service;

import com.btasdemir.dockerdemo.domain.converter.EmployeeConverter;
import com.btasdemir.dockerdemo.domain.dto.EmployeeDto;
import com.btasdemir.dockerdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto> getEmployees() {
        return employeeRepository.getEmployees().stream()
                .map(EmployeeConverter::convertToDto)
                .collect(Collectors.toList());
    }

}
