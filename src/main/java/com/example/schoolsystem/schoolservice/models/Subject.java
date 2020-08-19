package com.example.schoolsystem.schoolservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="subject_name")
    private String subjectName;

    @JsonIgnoreProperties(value = "subjects")
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<Teacher> teachers;

    @JsonIgnoreProperties(value = "subjects")
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<Exam> exams;

    @JsonIgnoreProperties(value = "subjects")
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @JsonIgnoreProperties(value = "subjects")
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    public Subject(String subjectName, Subject subject, Student student, Admin admin){
        this.subjectName = subjectName;
        this.teachers = new ArrayList<Teacher>();
        this.exams = new ArrayList<Exam>();
        this.student = student;
        this.admin = admin;
    }

    public Subject(){

    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
