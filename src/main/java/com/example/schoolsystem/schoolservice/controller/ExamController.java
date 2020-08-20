package com.example.schoolsystem.schoolservice.controller;

import com.example.schoolsystem.schoolservice.models.Exam;
import com.example.schoolsystem.schoolservice.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {

    @Autowired
    ExamRepository examRepository;

    @GetMapping(value = "/exams")
    public ResponseEntity<List<Exam>> getAllExams(){
        return new ResponseEntity<>(examRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/exams/{id}")
    public ResponseEntity getExam(@PathVariable Long id){
        return new ResponseEntity<>(examRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/exams/papername")
    public ResponseEntity findByPaperName(
            @RequestParam(name = "papername", required = false) String paperName){
        if(paperName != null){
            return new ResponseEntity(examRepository.findByPaperName(paperName), HttpStatus.OK);
        }
        return new ResponseEntity(examRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/exams/paperduration")
    public ResponseEntity findByPaperDuration(
            @RequestParam(name = "paperduration", required = false) String paperDuration){
        if(paperDuration != null){
            return new ResponseEntity(examRepository.findByPaperDuration(paperDuration), HttpStatus.OK);
        }
        return new ResponseEntity(examRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/exams")
    public ResponseEntity<Exam> postExam(@RequestBody Exam exam){
        examRepository.save(exam);
        return new ResponseEntity<>(exam, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/exams/{id}")
    public ResponseEntity<Exam> updateExam(@RequestBody Exam exam){
        examRepository.save(exam);
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @DeleteMapping(value = "/exams/{id}")
    public ResponseEntity<Exam> deleteExam(@PathVariable Long id){
        Exam found = examRepository.getOne(id);
        examRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }



}
