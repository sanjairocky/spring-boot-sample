package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Country;
import com.example.demo.model.Employee;

@Transactional
@Repository
public class CountryRepositoryImpl implements CountryRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Country createCountry(Country country) {
		
		entityManager.merge(country);
		return entityManager.find(Country.class,country.getCountry_id());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Country> getCountries() {
		String hql = "FROM Country as temp ORDER BY temp.Country_id";
		return (List<Country>) entityManager.createQuery(hql).getResultList();
	}
}
