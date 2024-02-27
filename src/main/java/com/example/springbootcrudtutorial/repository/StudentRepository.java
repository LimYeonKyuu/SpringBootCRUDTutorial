package com.example.springbootcrudtutorial.repository;

import com.example.springbootcrudtutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {}
