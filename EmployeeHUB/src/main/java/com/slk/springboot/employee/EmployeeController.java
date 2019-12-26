package com.slk.springboot.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employees")
	public List<Employee> getAllemployees() {
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping("/employees/{id}")
	
	public Employee getemployee(@PathVariable String id) {
		return employeeService.getEmployee(id);
	}
	
	//@PostMapping("/employees")
	@RequestMapping(method=RequestMethod.POST, value="/employees")
	public String addEmployee(@RequestBody Employee Employee) {
		employeeService.addEmployee(Employee);
		String response = "{\"success\": true, \"message\": Employee has been added successfully.}";
		return response;
	}
	
	//@RequestMapping(method=RequestMethod.PUT, value="/employees/{id}")
	@PutMapping("/employees")
	public String updateEmployee(@RequestBody Employee Employee, @RequestParam("id") String id) {
		employeeService.updateEmployee(id, Employee);
		String response = "{\"success\": true, \"message\": Employee has been updated successfully.}";
		return response;
	}
	
	//@RequestMapping(method=RequestMethod.DELETE, value="/employees/{id}")
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable String id) {
		employeeService.deleteEmployee(id);
		String response = "{\"success\": true, \"message\": Employee has been deleted successfully.}";
		return response;
	}
}
