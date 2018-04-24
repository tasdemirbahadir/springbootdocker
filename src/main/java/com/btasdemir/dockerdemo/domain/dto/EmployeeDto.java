package com.btasdemir.dockerdemo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDto {
    private String name;
    private String telephone;
}
