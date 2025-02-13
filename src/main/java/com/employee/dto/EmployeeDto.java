package com.employee.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Date createdDate;
	private Date updatedDate;
}
