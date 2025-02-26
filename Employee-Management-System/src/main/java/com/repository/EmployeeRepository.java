package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findBySalaryGreaterThan(double salary);
	List<Employee> findByExperienceGreaterThan(int experience);
	Employee findByName(String name);
	
//	@Query("SELECT e FROM Employee e INNER JOIN e.department d WHERE d.name = :departmentName")
//	List<Employee> findByDepartmentName(String departmentName);

}