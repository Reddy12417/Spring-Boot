package com.slk.springboot.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee> getAllEmployees() {
		return (List<Employee>) this.employeeRepository.findAll();
	}

	public Employee getEmployee(String id) {
		return (Employee) this.employeeRepository.findOne(id);
	}

	public void addEmployee(Employee Employee) {
		this.employeeRepository.save(Employee);
	}

	public void updateEmployee(String id, Employee Employee) {
		this.employeeRepository.save(Employee);
	}

	public void deleteEmployee(String id) {
		this.employeeRepository.delete(id);;
	}
}
