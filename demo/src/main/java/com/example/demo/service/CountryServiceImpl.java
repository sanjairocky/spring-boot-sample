package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Country;
import com.example.demo.model.Employee;
import com.example.demo.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public Country createCountry(Country country) {

		return countryRepository.createCountry(country);
				
	}
	
	@Override
	public List<Country> getCountries() {
		
		return countryRepository.getCountries();
	}

}
