package com.example.schoolsystem.schoolservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="student_name")
    private String studentName;

    @Column(name="student_phone")
    private String studentPhone;

    @Column(name="student_address")
    private String studentAddress;

    @JsonIgnoreProperties(value = "students")
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Exam> exams;

    @JsonIgnoreProperties(value = "students")
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Subject> subjects;

    @JsonIgnoreProperties(value = "students")
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @JsonIgnoreProperties(value = "students")
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    public Student(String studentName, String studentPhone, String studentAddress, Teacher teacher, Admin admin){
        this.studentName = studentName;
        this.studentPhone = studentPhone;
        this.studentAddress = studentAddress;
        this.exams = new ArrayList<Exam>();
        this.subjects = new ArrayList<Subject>();
        this.teacher = teacher;
        this.admin = admin;
    }

    public Student(){

    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
