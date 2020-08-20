package com.example.schoolsystem.schoolservice.repository;

import com.example.schoolsystem.schoolservice.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByTeacherName(String teacherName);
}
