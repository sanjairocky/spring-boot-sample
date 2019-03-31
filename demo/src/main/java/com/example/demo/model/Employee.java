package com.example.demo.model;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuppressWarnings("unused")
@Entity
@Table(name = "Employee")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Emp_id;
	
	@Column(nullable = false)
	private String Name;
	
	@Column(nullable = false)
	private String Email;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "Address_id")
	private Address address;
	
//	@Column(nullable = false, updatable = false)
//	@Temporal(TemporalType.TIMESTAMP)
//	@CreatedDate
//	private Date createdAt;
//	
//	@Column(nullable = false)
//	@Temporal(TemporalType.TIMESTAMP)
//	@LastModifiedDate
//	private Date updatedAt;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getEmp_id() {
		return Emp_id;
	}

//	public Date getCreatedAt() {
//		return createdAt;
//	}

//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}

	public void setEmp_id(int emp_id) {
		Emp_id = emp_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Employee [Emp_id=" + Emp_id + ", Name=" + Name + ", Email=" + Email + "]";
	}


	

}
