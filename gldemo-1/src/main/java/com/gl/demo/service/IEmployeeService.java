/**
 * 
 */
package com.gl.demo.service;

import java.util.List;
import java.util.Optional;

import com.gl.demo.model.Employee;

/**
 * The Interface IEmployeeService.
 *
 * @author vikas.kumar3
 */
public interface IEmployeeService {
	Optional<Employee> findOne(String id);

    List<Employee> findAll();

    List<Employee> findByName(String name);

    List<Employee> findByEmail(String email);

    void create(Employee emp);

    void update(Employee emp);

    void delete(Employee emp);
}
