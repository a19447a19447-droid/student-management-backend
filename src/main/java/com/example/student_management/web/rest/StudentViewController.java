package com.example.student_management.web.rest;

import com.example.student_management.service.StudentService;
import org.springframework.data.domain.Pageable; // Required import
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class StudentViewController {

    private final StudentService studentService;

    public StudentViewController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        // Use Pageable.unpaged() to satisfy the service requirement
        model.addAttribute("students", studentService.findAll(Pageable.unpaged()).getContent());
        return "student-list"; 
    }
}