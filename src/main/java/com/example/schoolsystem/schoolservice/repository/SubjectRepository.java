package com.example.schoolsystem.schoolservice.repository;

import com.example.schoolsystem.schoolservice.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Subject findBySubjectName(String subjectName);
}
