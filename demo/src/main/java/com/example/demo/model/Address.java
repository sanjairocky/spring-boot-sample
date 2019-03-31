package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Address")
@EntityListeners(AuditingEntityListener.class)
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Address_id;
	
	@Column(nullable = false)
	private String Address1;
	
	@Column(nullable = false)
	private String Address2;
	
	@Column(nullable = false)
	private String City;
	

	@ManyToOne(optional=false,targetEntity=Country.class)
    @JoinColumn(name = "Country_id")
	private Country country;
	
	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String address1) {
		Address1 = address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String address2) {
		Address2 = address2;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public int getAddress_id() {
		return Address_id;
	}

	public void setAddress_id(int address_id) {
		Address_id = address_id;
	}

	@Override
	public String toString() {
		return "Address [Address_id=" + Address_id + ", Address1=" + Address1 + ", Address2=" + Address2 + ", City="
				+ City + ", country=" + country + "]";
	}

	





}
