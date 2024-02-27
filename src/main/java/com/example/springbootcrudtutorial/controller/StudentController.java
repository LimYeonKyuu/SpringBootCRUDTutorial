package com.example.springbootcrudtutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/students")
    public String students() {
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm() {
        return "add_student";
    }
}
