package com.example.springbootcrudtutorial.service;

import com.example.springbootcrudtutorial.dto.StudentDto;
import com.example.springbootcrudtutorial.entity.Student;
import com.example.springbootcrudtutorial.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void addStudent(StudentDto dto){
        studentRepository.save(Student.from(dto));
    }
}
