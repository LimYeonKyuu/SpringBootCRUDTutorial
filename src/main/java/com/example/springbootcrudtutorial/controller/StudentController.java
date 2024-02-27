package com.example.springbootcrudtutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/students")
    public String students() {
        return "students";
    }

    @GetMapping("/students/add")
    public String createStudentForm() {
        return "add_student";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm() {
        return "edit_student";
    }
}
