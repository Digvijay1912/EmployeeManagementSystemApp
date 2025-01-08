package com.empmngsys.EmployeeManagementSystemApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.empmngsys.EmployeeManagementSystemApp.model.Employee;
import com.empmngsys.EmployeeManagementSystemApp.service.EmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmployeeController {

	@Autowired
    private EmployeeService employeeService;
	    
	    @GetMapping("/employees/{offset}/{pageSize}")
	    public Page<Employee> getAllEmployees(@PathVariable int offset, @PathVariable int pageSize) {
	    	return employeeService.getAllEmployees(offset, pageSize);
	    }    
	    
	    @GetMapping("/employeesSort/{offset}/{pageSize}/{field}")
	    public Page<Employee> getEmployees(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
	    	return employeeService.getEmployees(offset, pageSize, field);
	    } 
	    
	    @PostMapping("/employee")
	    public Employee createEmployee(@RequestBody Employee employee) {
	        return employeeService.createEmployee(employee);
	    }

	    @GetMapping("/employee/{id}")
	    public Employee getEmployeeById(@PathVariable Long id) {
	        return employeeService.getEmployeeById(id);
	    }

	    @PutMapping("/employee/{id}")
	    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
	        return employeeService.updateEmployee(id, employee);
	    }

	    @DeleteMapping("/employee/{id}")
	    public void deleteEmployee(@PathVariable Long id) {
	        employeeService.deleteEmployee(id);
	    }
	
}
