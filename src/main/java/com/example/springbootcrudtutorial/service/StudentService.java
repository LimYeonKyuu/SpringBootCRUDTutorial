package com.example.springbootcrudtutorial.service;

import com.example.springbootcrudtutorial.dto.StudentDto;
import com.example.springbootcrudtutorial.entity.Student;
import com.example.springbootcrudtutorial.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {
  private final StudentRepository studentRepository;

  public List<StudentDto> getStudents() {
    return studentRepository.findAll().stream().map(StudentDto::from).toList();
  }

  public void addStudent(StudentDto dto) {
    studentRepository.save(Student.from(dto));
  }

  public StudentDto getStudent(Long id) {
    return studentRepository.findById(id).map(StudentDto::from).orElseThrow();
  }

  public void editStudent(Long id, StudentDto dto) {
    Student student = studentRepository.findById(id).orElseThrow();
    student.update(dto);
  }

  public void deleteStudent(Long id) {
    studentRepository.deleteById(id);
  }
}
