package com.example.schoolsystem.schoolservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="password")
    private String password;

    @JsonIgnoreProperties(value = "admins")
    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    private List<Subject> subjects;

    @JsonIgnoreProperties(value = "admins")
    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    private List<Teacher> teachers;

    @JsonIgnoreProperties(value = "admins")
    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    private List<Student> students;

    public Admin(String fullName, String password){
        this.fullName = fullName;
        this.password = password;
        this.subjects = new ArrayList<Subject>();
        this.teachers = new ArrayList<Teacher>();
        this.students = new ArrayList<Student>();

    }

    public Admin(){

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
