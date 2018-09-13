/**
 * 
 */
package com.gl.demo.handler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.demo.model.Employee;
import com.gl.demo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The Class EmployeeHandler.
 *
 * @author vikas.kumar3
 */
@RestController
@Api(tags = "Employee Information")
@RequestMapping(path="/v2/employee")
public class EmployeeHandler {
	
	@Autowired
	private EmployeeService service;
	
	@ApiOperation(value = "Fetching employee by id")
	@GetMapping("/{id}")
	private ResponseEntity<Optional<Employee>> findEmpById(@PathVariable(value = "id") String id){
		return ResponseEntity.ok(service.findOne(id));
	}
}
