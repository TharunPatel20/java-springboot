package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.Department;
import com.entity.Employee;
import com.service.DepartmentService;
import com.service.EmployeeService;

@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
	DepartmentService depService ;
	@Autowired
	EmployeeService empService;

//	@Test
//	void addDepartment() {
//		Department actualDep = Department.builder().name("marketing").build();
//		Department expDep = depService.addDepartment(actualDep);
//		assertEquals(expDep, actualDep);
//		
//	}
	
	@Test
	void addEmployeeInDepartment() {
		Department dep = depService.getDepartmentById(1L);
		Employee actualEmp = Employee.builder()
									.name("arun")
									.salary(200000)
									.experience(2)
									.email("tharun@email.com")
									.department(dep)
									.build();
		
		depService.addEmployeeByDepartment(1, actualEmp);
		
		Employee expEmp = empService.getEmployeeByName("arun");
		assertEquals(expEmp, actualEmp);
		verify(depService, times(1)).addEmployeeByDepartment(1, actualEmp);
	}

}
