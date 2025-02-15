package com.example.demo.service;

import com.example.demo.model.College;
import com.example.demo.model.Student;
import com.example.demo.repository.CollegeRepository;
import com.example.demo.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    CollegeRepository collegeRepo;
    @Autowired
    StudentRepository studentRepo;

    public College createCollege(College college) {
// create college
        return collegeRepo.save(college);
    }

    public Student createStudent(Long collegeId, Student student) {
// create student
        College college = collegeRepo
                .findById(collegeId)
                .orElseThrow(()->
                        new EntityNotFoundException("college not found"));
        student.setCollege(college);
        return studentRepo.save(student);
    }
    public List<College> getAllColleges() {
// get all colleges
        return collegeRepo.findAll();
    }

    public List<Student> getStudentsByCollegeName(String collegeName) {
// Fetch all the students for a particular college based on their name in descending order
        return studentRepo.findByCollege_nameOrderByNameDesc(collegeName);
    }
}