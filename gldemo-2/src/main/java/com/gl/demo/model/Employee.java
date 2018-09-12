/**
 * 
 */
package com.gl.demo.model;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class Employee.
 * @author vikas.kumar3
 */
@Document
public class Employee {
	
    /** The id. */
    @Id
    private String id;
    
    /** The emp id. */
    private String empId;
    
    /** The name. */
    private String name;
    
    /** The project name. */
    private String projectName;
    
    /** The email. */
    private String email;
    
    /** The address. */
    private String address;
    
    @JsonIgnore
    /** The created. */
    private DateTime created;
    
    /** The updated. */
    private DateTime updated;

  
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public DateTime getCreated() {
		return created;
	}
	public void setCreated(DateTime created) {
		this.created = created;
	}
	public DateTime getUpdated() {
		return updated;
	}
	public void setUpdated(DateTime updated) {
		this.updated = updated;
	}
}
