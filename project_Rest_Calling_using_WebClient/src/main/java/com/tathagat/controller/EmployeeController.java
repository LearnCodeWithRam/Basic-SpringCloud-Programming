package com.tathagat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tathagat.Entity.Employee;
import com.tathagat.employeeService.EmployeeService;
import com.tathagat.employeerepo.EmployeeRepo;
import com.tathagat.response.EmployeeResponse;

@RestController

public class EmployeeController {
	
	
	@Autowired
	private EmployeeService empserv;
	
	/**
	@GetMapping(path="/Employees/{id}")
	//don't return the employee entity directly 
	//public Employee getEmployeeDetails(@PathVariable("id") Integer id)
	//{
		
     return empserv.getEmpById(id);//return a model/response obj instead
		
	}
	*/
	
	
	/**@GetMapping(path="/Employees/{id}")
	public EmployeeResponse getEmployeeDetails(@PathVariable("id") Integer id)
	{
		
		
     return empserv.getEmpById(id);//return a model/response obj instead
		
	}*/
	
	@GetMapping(path="/Employees/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") Integer id)
	{
		
		EmployeeResponse resp = empserv.getEmpById(id);//return a model/response obj instead
     
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
		
	}

}
