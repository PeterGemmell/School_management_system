package com.example.schoolsystem.schoolservice.repository;

import com.example.schoolsystem.schoolservice.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByStudentName(String studentName);
}
