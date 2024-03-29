package com.example.springbootcrudtutorial.dto;

import com.example.springbootcrudtutorial.controller.request.AddStudentRequest;
import com.example.springbootcrudtutorial.controller.request.EditStudentRequest;
import com.example.springbootcrudtutorial.entity.Student;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public static StudentDto from(AddStudentRequest request){
        return StudentDto.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
    }

    public static StudentDto from(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .build();
    }

    public static StudentDto from(EditStudentRequest request) {
        return StudentDto.builder()
                .id(request.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
    }
}
