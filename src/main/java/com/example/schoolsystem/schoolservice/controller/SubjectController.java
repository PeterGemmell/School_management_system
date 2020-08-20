package com.example.schoolsystem.schoolservice.controller;

import com.example.schoolsystem.schoolservice.models.Student;
import com.example.schoolsystem.schoolservice.models.Subject;
import com.example.schoolsystem.schoolservice.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping(value = "/subjects")
    public ResponseEntity<List<Subject>> getAllSubjects(){
        return new ResponseEntity<>(subjectRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/subjects/{id}")
    public ResponseEntity getSubject(@PathVariable Long id){
        return new ResponseEntity<>(subjectRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/subjects/subjectname")
    public ResponseEntity findBySubjectName(
            @RequestParam(name = "subjectname", required = false) String subjectName){
        if(subjectName != null){
            return new ResponseEntity(subjectRepository.findBySubjectName(subjectName), HttpStatus.OK);
        }
        return new ResponseEntity(subjectRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/subjects")
    public ResponseEntity<Subject> postSubject(@RequestBody Subject subject){
        subjectRepository.save(subject);
        return new ResponseEntity<>(subject, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/subjects/{id}")
    public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject){
        subjectRepository.save(subject);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @DeleteMapping(value = "/subjects/{id}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable Long id){
        Subject found = subjectRepository.getOne(id);
        subjectRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }



}
