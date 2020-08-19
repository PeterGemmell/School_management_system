package com.example.schoolsystem.schoolservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="paper_name")
    private String paperName;

    @Column(name="paper_duration")
    private String paperDuration;

    @JsonIgnoreProperties(value = "exams")
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @JsonIgnoreProperties(value = "exams")
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @JsonIgnoreProperties(value = "exams")
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public Exam(String paperName, String paperDuration, Teacher teacher, Subject subject, Student student){
        this.paperName = paperName;
        this.paperDuration = paperDuration;
        this.teacher = teacher;
        this.subject = subject;
        this.student = student;
    }

    public Exam(){

    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getPaperDuration() {
        return paperDuration;
    }

    public void setPaperDuration(String paperDuration) {
        this.paperDuration = paperDuration;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
