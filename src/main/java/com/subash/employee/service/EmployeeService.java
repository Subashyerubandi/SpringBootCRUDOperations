package com.subash.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.subash.employee.model.Employee;
import com.subash.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repo;

	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
	}
	
	public ResponseEntity<Employee> getById(int id) {
		Optional<Employee> op = repo.findById(id);
		if(op.isPresent()) {
			return new ResponseEntity<>(op.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Employee> addEmployee(Employee emp) {
		return new ResponseEntity<>(repo.save(emp), HttpStatus.CREATED);
	}

	public ResponseEntity<Employee> updateEmployee(Employee emp, int id) {
		Optional<Employee> op = repo.findById(id);
		if(op.isPresent()) {
			op.get().setEmpName(emp.getEmpName());
			op.get().setPassword(emp.getPassword());
			return new ResponseEntity<>(repo.save(op.get()), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Void> deleteEmployee(int id) {
		Optional<Employee> op = repo.findById(id);
		if(op.isPresent()) {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
