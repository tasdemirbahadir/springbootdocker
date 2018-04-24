package com.btasdemir.dockerdemo.domain.converter;

import com.btasdemir.dockerdemo.domain.Employee;
import com.btasdemir.dockerdemo.domain.dto.EmployeeDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeConverterTest {

    @Test
    public void should_convert_employee_to_dto() {
        //given
        Employee employee = new Employee("Ahmet", "054322355334");

        //when
        EmployeeDto employeeDto = EmployeeConverter.convertToDto(employee);

        //then
        assertThat(employeeDto).isNotNull();
        assertThat(employeeDto.getName()).isEqualTo(employee.getName());
        assertThat(employeeDto.getTelephone()).isEqualTo(employee.getTelephone());
    }

}