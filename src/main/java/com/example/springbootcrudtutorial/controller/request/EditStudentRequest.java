package com.example.springbootcrudtutorial.controller.request;

import com.example.springbootcrudtutorial.dto.StudentDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EditStudentRequest {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;

  public static EditStudentRequest from(StudentDto dto) {
    return EditStudentRequest.builder()
        .id(dto.getId())
        .firstName(dto.getFirstName())
        .lastName(dto.getLastName())
        .email(dto.getEmail())
        .build();
  }
}
