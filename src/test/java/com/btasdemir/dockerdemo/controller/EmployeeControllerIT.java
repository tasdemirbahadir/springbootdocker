package com.btasdemir.dockerdemo.controller;

import com.btasdemir.dockerdemo.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void should_get_employees() {
        //given
        ParameterizedTypeReference<List<Employee>> employeesResponseType = new ParameterizedTypeReference<List<Employee>>() {};

        //when
        ResponseEntity<List<Employee>> employeesResponseEntity = restTemplate.exchange("/employee/employees", HttpMethod.GET, null, employeesResponseType);

        //then
        assertThat(employeesResponseEntity).isNotNull();
        assertThat(employeesResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(employeesResponseEntity.getBody()).hasSize(4);
    }

}
