package com.example.springbootcrudtutorial.controller;

import com.example.springbootcrudtutorial.controller.request.AddStudentRequest;
import com.example.springbootcrudtutorial.controller.request.EditStudentRequest;
import com.example.springbootcrudtutorial.controller.response.StudentResponse;
import com.example.springbootcrudtutorial.dto.StudentDto;
import com.example.springbootcrudtutorial.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
  public String editStudentForm(Model model, @PathVariable Long id) {
    model.addAttribute("student", EditStudentRequest.from(studentService.getStudent(id)));
    return "edit_student";
  }

  @PostMapping("/students/edit/{id}")
  public String editStudent(
      @ModelAttribute("student") EditStudentRequest request, @PathVariable Long id) {
    studentService.editStudent(id, StudentDto.from(request));
    return "redirect:/students";
  }

  @GetMapping("/students/delete/{id}")
  public String deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
    return "redirect:/students";
  }
}
