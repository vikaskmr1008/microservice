/**
 * 
 */
package com.gl.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gl.demo.model.Employee;
import com.gl.demo.repo.IEmployeeRepository;

/**
 * The Class EmployeeService.
 *
 * @author vikas.kumar3
 */
@Component
public class EmployeeService implements IEmployeeService {
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

	public List<Employee> findByName(String name) {
		return repo.findByName(name);
	}

	public List<Employee> findByEmail(String email) {
		return repo.findByEmail(email);
	}

	public void create(Employee emp) {
		emp.setId(UUID.randomUUID().toString());
		emp.setCreated(DateTime.now());
        repo.save(emp);
	}

	public void update(Employee emp) {
		emp.setUpdated(DateTime.now());
        repo.save(emp);
		
	}

	public void delete(Employee emp) {
		repo.delete(emp);
	}
}
