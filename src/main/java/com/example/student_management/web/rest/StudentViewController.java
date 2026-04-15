package com.example.student_management.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.student_management.service.StudentService;
import com.example.student_management.service.dto.StudentDTO;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/view")
public class StudentViewController {

    private final StudentService studentService;

    public StudentViewController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/new")
    public String showCreateForm(Model model) {
        model.addAttribute("studentDTO", new StudentDTO());
        return "create-student";
    }

    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("studentDTO") StudentDTO studentDTO, 
                              BindingResult result, 
                              Model model) {
        // Requirement Check: Checks if Name/Surname fulfill StudentDTO constraints
        if (result.hasErrors()) {
            return "create-student"; 
        }

        studentService.save(studentDTO);
        model.addAttribute("successMessage", "Student added successfully!");
        model.addAttribute("studentDTO", new StudentDTO()); // Reset form
        return "create-student";
    }
}