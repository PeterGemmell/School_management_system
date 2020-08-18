package com.example.schoolsystem.schoolservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="teacher_name")
    private String teacherName;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="teacher_address")
    private String teacherAddress;

    @JsonIgnoreProperties(value = "teachers")
    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<Exam> exams;
}
