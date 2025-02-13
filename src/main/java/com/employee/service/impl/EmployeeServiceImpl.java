package com.employee.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.exception.ResourceNotFoundException;
import com.employee.mapper.EmployeeMapper;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository ;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		
		employee.setCreatedDate(new Date());
		
		Employee savedEmployee = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId)
		.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found With Id : " + employeeId));
		
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		List<Employee> empList = employeeRepository.findAll();
		
		return empList.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		
		Employee employee= employeeRepository.findById(employeeId)
				           .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found With Given Id " + employeeId));
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		employee.setUpdatedDate(new Date());
		
		Employee updatedEmployeeObj = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found With Id : " + employeeId));
	
		employeeRepository.deleteById(employeeId);
	}

}
