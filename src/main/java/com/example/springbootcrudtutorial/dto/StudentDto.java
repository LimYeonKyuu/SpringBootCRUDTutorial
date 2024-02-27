package com.example.springbootcrudtutorial.dto;

import com.example.springbootcrudtutorial.controller.request.AddStudentRequest;
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
}
