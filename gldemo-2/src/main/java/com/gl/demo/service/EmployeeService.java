package com.gl.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gl.demo.model.Employee;
import com.gl.demo.repo.IEmployeeRepository;

@Component
public class EmployeeService {
	
	@Autowired
	private IEmployeeRepository repo;
	
	public Optional<Employee> findOne(String id) {
		return repo.findById(id);
	}

	public List<Employee> findAll() {
		List<Employee> emp = new ArrayList<Employee>();
        Iterator<Employee> it = repo.findAll().iterator();
        while (it.hasNext()) {
            emp.add(it.next());
        }
		return emp;
	}
}
