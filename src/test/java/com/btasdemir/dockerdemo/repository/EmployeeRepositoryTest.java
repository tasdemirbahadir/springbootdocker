package com.btasdemir.dockerdemo.repository;

import com.btasdemir.dockerdemo.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class EmployeeRepositoryTest {

    @InjectMocks
    private EmployeeRepository employeeRepository;

    @Test
    public void should_get_employees() {
        //given
        //when
        List<Employee> employees = employeeRepository.getEmployees();

        //then
        assertThat(employees).isNotNull();
        assertThat(employees).hasSize(4);
    }

}