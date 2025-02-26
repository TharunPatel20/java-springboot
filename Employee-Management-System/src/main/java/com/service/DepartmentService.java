package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Department;
import com.entity.Employee;
import com.repository.DepartmentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public Department getDepartmentById(Long i) {
		return departmentRepository.findById(i).orElse(null);  
	}
	
	public List<Department> getAllDepartments(){	
		return departmentRepository.findAll();
	}
	
	public List<Department> getAllDepartmentsByName(String name){	
		return departmentRepository.findByName(name);
	}
	
	public Department addDepartment(Department department) {
		return departmentRepository.saveAndFlush(department);
	}
	
	public Department updateDepartment(long depId, Department department ) {
		Department updateDep = departmentRepository.findById(depId).orElseThrow(()-> new EntityNotFoundException("department not found"));
		updateDep.setName(department.getName());
		return updateDep;
	}
	
	public Department addEmployeeByDepartment(long depId, Employee employee ) {
		Department updateDep = departmentRepository.findById(depId).orElseThrow(()-> new EntityNotFoundException("department not found"));
		updateDep.addEmployee(employee);
		 departmentRepository.save(updateDep);
		return updateDep;
	}
	
	public void deleteDepartment(Long departmentId) {
		departmentRepository.deleteById(departmentId);  
	}
	
	public List<Employee> getAllEmployeesByDepartmentId(Long Id){	
	Department dep =  departmentRepository.findById(Id).orElse(null);
	return dep.getEmployees();
	}

}
