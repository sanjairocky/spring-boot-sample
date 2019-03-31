package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Country;

public interface CountryRepository {

	Country createCountry(Country country);
	public List<Country> getCountries();
}
