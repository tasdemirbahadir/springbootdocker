package com.btasdemir.dockerdemo.repository;

import com.btasdemir.dockerdemo.domain.Employee;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EmployeeRepository {

    public List<Employee> getEmployees() {
        return Arrays.asList(new Employee("Ahmet", "5051212"),
            new Employee("Mehmet", "5051212"),
            new Employee("Ayse", "5051212"),
            new Employee("Fatma", "5051212"));
    }

}
