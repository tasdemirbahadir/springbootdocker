package com.btasdemir.dockerdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private String telephone;
}
