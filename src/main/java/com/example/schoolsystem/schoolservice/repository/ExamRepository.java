package com.example.schoolsystem.schoolservice.repository;

import com.example.schoolsystem.schoolservice.models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    Exam findByPaperName(String paperName);

    Exam findByPaperDuration(String paperDuration);
}
