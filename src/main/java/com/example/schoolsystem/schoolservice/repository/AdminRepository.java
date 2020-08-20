package com.example.schoolsystem.schoolservice.repository;

import com.example.schoolsystem.schoolservice.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByFullName(String fullName);
}
