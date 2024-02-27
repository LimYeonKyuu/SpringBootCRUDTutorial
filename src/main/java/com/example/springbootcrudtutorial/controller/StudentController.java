package com.example.springbootcrudtutorial.controller;

import com.example.springbootcrudtutorial.controller.request.AddStudentRequest;
import com.example.springbootcrudtutorial.controller.response.StudentResponse;
import com.example.springbootcrudtutorial.dto.StudentDto;
import com.example.springbootcrudtutorial.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", StudentResponse.listFrom(studentService.getStudents()));
        return "students";
    }

    @GetMapping("/students/add")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new AddStudentRequest());
        return "add_student";
    }

    @PostMapping("/students/add")
    public String createStudent(@ModelAttribute("student") AddStudentRequest request) {
        studentService.addStudent(StudentDto.from(request));
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm() {
        return "edit_student";
    }
}
