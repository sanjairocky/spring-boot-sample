package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Country;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getEmployees() {
		
		return employeeRepository.getEmployees();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		
		return employeeRepository.createEmployee(employee);
		
	}

	@Override
	public Employee updateEmployee(int employeeId, Employee employee) {
		
		return employeeRepository.updateEmployee(employeeId, employee);
		
	}

	@Override
	public Employee getEmployee(int employeeId) {
		
		return employeeRepository.getEmployee(employeeId);
		
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		
		return employeeRepository.deleteEmployee(employeeId);
		
	}

}
