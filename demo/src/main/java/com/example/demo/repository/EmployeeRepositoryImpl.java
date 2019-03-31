package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Country;
import com.example.demo.model.Employee;

@Transactional
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployees() {
		String hql = "FROM Employee as temp ORDER BY temp.id";
		return (List<Employee>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Employee getEmployee(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		entityManager.merge(employee);
		Employee b = getLastInsertedEmployee();
		return b;
	}

	@Override
	public Employee updateEmployee(int employeeId, Employee employee) {
		
		Employee emp = getEmployee(employeeId);
		
		emp.setAddress(employee.getAddress());
		emp.setEmail(employee.getEmail());
//		emp.setEmp_id(employee.getEmp_id());
//		emp.setName(employee.getName());
		
		entityManager.flush();
	 
		return getEmployee(employeeId);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		Employee employee = getEmployee(employeeId);
		entityManager.remove(employee);
	
		if(entityManager.contains(employee)){
			return false;
		}
		return true;
	}
	
	private Employee getLastInsertedEmployee(){
		String hql = "from Employee order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		
		return (Employee)query.getSingleResult();
		
	}

}
