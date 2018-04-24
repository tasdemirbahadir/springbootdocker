package com.btasdemir.dockerdemo.service;

import com.btasdemir.dockerdemo.domain.Employee;
import com.btasdemir.dockerdemo.domain.dto.EmployeeDto;
import com.btasdemir.dockerdemo.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void should_get_employees() {
        //given
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Ayşe", "324324"));
        employees.add(new Employee("Fatma", "123123"));
        given(employeeRepository.getEmployees()).willReturn(employees);

        //when
        List<EmployeeDto> returnedEmployees = employeeService.getEmployees();

        //then
        assertThat(returnedEmployees).isNotNull();
        assertThat(returnedEmployees).hasSize(employees.size());
        assertThat(returnedEmployees.get(0).getName()).isEqualTo(employees.get(0).getName());
        assertThat(returnedEmployees.get(0).getTelephone()).isEqualTo(employees.get(0).getTelephone());
        assertThat(returnedEmployees.get(1).getName()).isEqualTo(employees.get(1).getName());
        assertThat(returnedEmployees.get(1).getTelephone()).isEqualTo(employees.get(1).getTelephone());
    }

}