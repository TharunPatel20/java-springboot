package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	List<Department> findByName(String name);

}
