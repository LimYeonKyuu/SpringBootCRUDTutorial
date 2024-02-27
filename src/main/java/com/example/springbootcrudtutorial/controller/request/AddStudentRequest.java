package com.example.springbootcrudtutorial.controller.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AddStudentRequest {
    private String firstName;
    private String lastName;
    private String email;
}
