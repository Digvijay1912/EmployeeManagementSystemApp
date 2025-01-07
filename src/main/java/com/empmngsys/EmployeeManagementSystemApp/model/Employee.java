package com.empmngsys.EmployeeManagementSystemApp.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String name;
    private String email;
    private String department;
    private String position;
    private Double salary;
    
    @Temporal(TemporalType.DATE)
    private Date dateOfJoining;
    
    public Employee(){}
	
    public Employee(Long id, String name, String email, String department, String position, Double salary,
			Date dateOfJoining) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.position = position;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department
				+ ", position=" + position + ", salary=" + salary + ", dateOfJoining=" + dateOfJoining + "]";
	}
}
