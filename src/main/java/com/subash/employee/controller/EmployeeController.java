package com.subash.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.subash.employee.model.Employee;
import com.subash.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("")
	public String greet() {
		return "Welcome...." ;
	}
	
	@GetMapping("readEmployee")
	public ResponseEntity<List<Employee>> getEmployees(){
		return service.getEmployees();
	}
	
	@GetMapping("readEmployee/{id}")
	public ResponseEntity<Employee> getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PostMapping("createEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		return service.addEmployee(emp);
	}
	
	@PutMapping("updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp,@PathVariable int id) {
		return service.updateEmployee(emp, id);
	}
	
	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}
	
}
