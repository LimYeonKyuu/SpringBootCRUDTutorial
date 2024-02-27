package com.example.springbootcrudtutorial.controller.response;

import com.example.springbootcrudtutorial.dto.StudentDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public static List<StudentResponse> listFrom(List<StudentDto> dtos){
        return dtos.stream().map(StudentResponse::from).toList();
    }

    public static StudentResponse from(StudentDto dto){
        return StudentResponse.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .build();
    }
}
