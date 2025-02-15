package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String courseTaken;
    private int marks;

    @ManyToOne
    @JoinColumn(name = "college_id", nullable = false)
    @JsonBackReference
    private College college;

    public Student() {}

    public Student(Long id, String name, String courseTaken, int marks, College college) {
        this.id = id;
        this.name = name;
        this.courseTaken = courseTaken;
        this.marks = marks;
        this.college = college;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCourseTaken() { return courseTaken; }
    public void setCourseTaken(String courseTaken) { this.courseTaken = courseTaken; }

    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }

    public College getCollege() { return college; }
    public void setCollege(College college) { this.college = college; }
}
