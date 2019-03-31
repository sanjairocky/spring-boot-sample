package com.example.demo.repository;

import java.util.List;
import com.example.demo.model.Employee;


public interface EmployeeRepository {
	
	List<Employee> getEmployees();
	Employee getEmployee(int employeeId);
	Employee createEmployee(Employee employee);
	Employee updateEmployee(int employeeId,Employee employee);
	boolean deleteEmployee(int employeeId);	

}
