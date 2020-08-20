package com.example.schoolsystem.schoolservice.controller;

import com.example.schoolsystem.schoolservice.models.Exam;
import com.example.schoolsystem.schoolservice.models.Student;
import com.example.schoolsystem.schoolservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/students/{id}")
    public ResponseEntity getStudent(@PathVariable Long id){
        return new ResponseEntity<>(studentRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/students/studentname")
    public ResponseEntity findByStudentName(
            @RequestParam(name = "studentname", required = false) String studentName){
        if(studentName != null){
            return new ResponseEntity(studentRepository.findByStudentName(studentName), HttpStatus.OK);
        }
        return new ResponseEntity(studentRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/students")
    public ResponseEntity<Student> postStudent(@RequestBody Student student){
        studentRepository.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/students/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        studentRepository.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        Student found = studentRepository.getOne(id);
        studentRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
