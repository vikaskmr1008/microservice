package com.gl.demo.repo;

import java.util.List;

import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.repository.CrudRepository;

import com.gl.demo.model.Employee;


@ViewIndexed(designDoc = "employee")
public interface IEmployeeRepository extends CrudRepository<Employee, String> {
	List<Employee> findByName(String name);
    List<Employee> findByEmail(String email);
}
