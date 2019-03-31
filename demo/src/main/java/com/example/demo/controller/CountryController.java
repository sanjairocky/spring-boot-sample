package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Country;
import com.example.demo.model.Employee;
import com.example.demo.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1.0")
@Api(value="CountryController",produces=MediaType.APPLICATION_JSON_VALUE)
public class CountryController {

	@Autowired
	CountryService countryService;
	
	@PostMapping("/Country")
	@ApiOperation("Create a new Country")
	public ResponseEntity<Country> createCountry(@Valid @RequestBody Country country) {
		return new ResponseEntity<Country>(countryService.createCountry(country), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/Countries")
	@ApiOperation("Get all countries")
	public Iterable<Country> getCountries() {
		return countryService.getCountries();
	}
}
