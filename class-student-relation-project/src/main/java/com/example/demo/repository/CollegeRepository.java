package com.example.demo.repository;

import com.example.demo.model.College;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CollegeRepository extends JpaRepository<College,Long> {
}
