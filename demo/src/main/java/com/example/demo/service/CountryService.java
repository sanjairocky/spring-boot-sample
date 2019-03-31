package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Country;

public interface CountryService {
	
	Country createCountry(Country country);
	public List<Country> getCountries();

}
