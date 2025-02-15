package com.example.demo.controller;

import com.example.demo.model.College;
import com.example.demo.model.Student;
import com.example.demo.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    CollegeService collegeService;

    @PostMapping
//    localhost:1009/college
    public ResponseEntity<College> createCollege(@RequestBody College college) {
// create a college and return it with a 201 Created status code
        return new ResponseEntity<College>(collegeService.createCollege(college),HttpStatus.CREATED);
    }

    @PostMapping("/{collegeId}")
//    localhost:1009/college/1
    public ResponseEntity<Student> createStudent(@PathVariable Long collegeId, @RequestBody Student student) {
// create a student and return it with a 201 Created status code
        return new ResponseEntity<>(collegeService.createStudent(collegeId, student),HttpStatus.CREATED);
    }

    @GetMapping("/all")
//    localhost:1009/college/all
    public ResponseEntity<List<College>> getAllColleges() {
// return all colleges with a 200 OK status code
        return new ResponseEntity<>(collegeService.getAllColleges(),HttpStatus.OK);
    }

    @GetMapping("/collegeName")
//    http://localhost:1009/college/collegeName?collegeName=abc

    public ResponseEntity<List<Student>> getStudentsByCollegeName(@RequestParam String collegeName) {
// return all students of a college with a 200 OK status code
        return new ResponseEntity<>(collegeService.getStudentsByCollegeName(collegeName),HttpStatus.OK);
    }
}
