package com.empmngsys.EmployeeManagementSystemApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.empmngsys.EmployeeManagementSystemApp.model.Employee;
import com.empmngsys.EmployeeManagementSystemApp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;
    

    public Page<Employee> findAllEmployees(int offset, int pageSize){
		 return employeeRepository.findAll(PageRequest.of(offset, pageSize));    	
    }
    
    public Page<Employee> findEmployees(int offset, int pageSize,String field){
		return employeeRepository.findAll(PageRequest.of(offset, pageSize).withSort(Direction.ASC, field));  	
    }
    
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = getEmployeeById(id);
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setPosition(employeeDetails.getPosition());
        employee.setSalary(employeeDetails.getSalary());
        employee.setDateOfJoining(employeeDetails.getDateOfJoining());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }

}
