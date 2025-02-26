package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Employee;
import com.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository; 
	
	
	public Employee addEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
	public void deleteEmployee(Long empId) {
		employeeRepository.deleteById(empId);  
	}
	
	public Employee updateEmployee(long empId, Employee emp ) {
		Employee updateEmp = employeeRepository.findById(empId)
				.orElseThrow(()-> new EntityNotFoundException("Employee not found"));
		Employee.builder()
		.email(emp.getEmail())
		.name(emp.getName())
		.salary(emp.getSalary())
		.experience(emp.getExperience())
		.department(emp.getDepartment())
		.build();
		return employeeRepository.saveAndFlush(updateEmp);
	}
	
	public void getEmployee(Long empId) {
		employeeRepository.findById(empId);  
	}
	
	public List<Employee> getAllEmployees(){	
		return employeeRepository.findAll();
	}
	
	public List<Employee> getEmployeesBySalaryGreaterThan(double salary){
		return employeeRepository.findBySalaryGreaterThan(salary);
	}
	
	public List<Employee> getEmployeesByExperienceGreaterThan(int experience){
		return employeeRepository.findByExperienceGreaterThan(experience);
	}
	public Employee getEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}
	

}
