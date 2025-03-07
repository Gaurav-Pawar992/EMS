package com.employee.mapper;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getCreatedDate(),
				employee.getUpdatedDate()
		);
	}
	
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail(),
				employeeDto.getCreatedDate(),
				employeeDto.getUpdatedDate()
		);
	}
	
}
