package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;


public interface EmployeeService {

	List<Employee> getEmployees();
	Employee createEmployee(Employee employee);
	Employee updateEmployee(int employeeId, Employee employee);
	Employee getEmployee(int employeeId);
	boolean deleteEmployee(int employeeId);
}
