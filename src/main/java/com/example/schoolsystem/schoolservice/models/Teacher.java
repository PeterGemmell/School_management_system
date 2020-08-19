package com.example.schoolsystem.schoolservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
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

    @JsonIgnoreProperties(value = "teachers")
    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<Student> students;

    @JsonIgnoreProperties(value = "teachers")
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    @JsonIgnoreProperties(value = "teachers")
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    public Teacher(String teacherName, String teacherAddress, Admin admin, Subject subject){
        this.teacherName = teacherName;
        this.teacherAddress = teacherAddress;
        this.exams = new ArrayList<Exam>();
        this.students = new ArrayList<Student>();
        this.admin = admin;
        this.subject = subject;
    }

    public Teacher(){

    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
