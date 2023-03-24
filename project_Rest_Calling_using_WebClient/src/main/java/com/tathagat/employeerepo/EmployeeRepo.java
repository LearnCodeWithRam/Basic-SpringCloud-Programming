package com.tathagat.employeerepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tathagat.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> 
{

}
