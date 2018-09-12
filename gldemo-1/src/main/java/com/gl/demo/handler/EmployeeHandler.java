/**
 * 
 */
package com.gl.demo.handler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.demo.model.Employee;
import com.gl.demo.service.IEmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The Class EmployeeHandler.
 *
 * @author vikas.kumar3
 */
@RestController
@Api(tags = "Employee Information")
@RequestMapping(path="/v1/employee")
public class EmployeeHandler {
	
	@Autowired
	private IEmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<Employee>> allEmployee() {
		List<Employee> empList = service.findAll();
		if (empList.isEmpty()) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Fetching employee by id")
	@GetMapping("/{id}")
	private ResponseEntity<Optional<Employee>> findEmpById(@PathVariable(value = "id") String id){
		return ResponseEntity.ok(service.findOne(id));
	}
	@ApiOperation(value = "adding a new employee")
	@PostMapping
	public ResponseEntity<Employee> createResource(@Valid @RequestBody Employee emp){
		service.create(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
}
