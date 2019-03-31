package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Country")
@EntityListeners(AuditingEntityListener.class)
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Country_id;
	
	@Column(nullable = false)
	private String CountryName;
	
//	@OneToMany( mappedBy = "country")
//	private Address address;

	

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	public int getCountry_id() {
		return Country_id;
	}

	public void setCountry_id(int country_id) {
		Country_id = country_id;
	}

	@Override
	public String toString() {
		return "Country [Country_id=" + Country_id + ", CountryName=" + CountryName + "]";
	}



}
