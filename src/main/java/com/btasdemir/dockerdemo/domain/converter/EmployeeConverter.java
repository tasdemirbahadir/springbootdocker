package com.btasdemir.dockerdemo.domain.converter;

import com.btasdemir.dockerdemo.domain.Employee;
import com.btasdemir.dockerdemo.domain.dto.EmployeeDto;

public class EmployeeConverter {

    public static EmployeeDto convertToDto(Employee employee) {
        return new EmployeeDto(employee.getName(), employee.getTelephone());
    }

}
