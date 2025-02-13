package com.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
@AllArgsConstructor

public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@PostMapping("/add")
	public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employeeDto){
		
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<EmployeeDto> getById(@PathVariable ("id") Long empId){
		EmployeeDto employeeDto = employeeService.getEmployeeById(empId);
		return ResponseEntity.ok(employeeDto);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List <EmployeeDto>> getAll(){
		
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		
		return ResponseEntity.ok(employees);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDto> update(@PathVariable ("id") Long empId , 
											  @RequestBody EmployeeDto employeeDto){
		
		EmployeeDto updatedEmployee = employeeService.updateEmployee(empId, employeeDto);
		
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable ("id") Long empId){
		
		employeeService.deleteEmployee(empId);
		
		return ResponseEntity.ok("Employee Deleted Successfully.");
	}
}
