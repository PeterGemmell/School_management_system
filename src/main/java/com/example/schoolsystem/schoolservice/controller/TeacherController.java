package com.example.schoolsystem.schoolservice.controller;

import com.example.schoolsystem.schoolservice.models.Teacher;
import com.example.schoolsystem.schoolservice.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping(value = "/teachers")
    public ResponseEntity<List<Teacher>> getAllTeachers(){
        return new ResponseEntity<>(teacherRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/teachers/{id}")
    public ResponseEntity getTeacher(@PathVariable Long id){
        return new ResponseEntity<>(teacherRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/teachers/teachername")
    public ResponseEntity findByTeacherName(
            @RequestParam(name = "teachername", required = false) String teacherName){
        if(teacherName != null){
            return new ResponseEntity(teacherRepository.findByTeacherName(teacherName), HttpStatus.OK);
        }
        return new ResponseEntity(teacherRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/teachers")
    public ResponseEntity<Teacher> postTeacher(@RequestBody Teacher teacher){
        teacherRepository.save(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/teachers/{id}")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher){
        teacherRepository.save(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @DeleteMapping(value = "/teachers/{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable Long id){
        Teacher found = teacherRepository.getOne(id);
        teacherRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
