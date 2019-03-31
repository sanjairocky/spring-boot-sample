package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Country;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1.0")
@Api(value="EmployeeController",produces=MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public @ResponseBody String sayHello(){
		return "/swagger-ui";
	}
	@GetMapping("/Employees")
	public Iterable<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/Employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") int id) {
//		 employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
		return new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.ACCEPTED);
		 
		 
	}

	@PostMapping("/Employee")
	@ApiOperation("Create a new employee")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.createEmployee(employee), HttpStatus.ACCEPTED);
	}

	@PutMapping("/Employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") int id, @Valid @RequestBody Employee EmployeeDetails) {

		
		return new ResponseEntity<Employee>(employeeService.updateEmployee(id, EmployeeDetails), HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/Employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") int id) {

       if(employeeService.deleteEmployee(id)) {
       return new ResponseEntity<Employee>( HttpStatus.ACCEPTED);
       }else {
    	   return new ResponseEntity<Employee>( HttpStatus.FAILED_DEPENDENCY);
       }
	}
}
