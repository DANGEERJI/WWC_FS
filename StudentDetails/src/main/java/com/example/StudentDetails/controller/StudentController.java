package com.example.StudentDetails.controller;
import com.example.StudentDetails.service.StudentService;
import org.springframework.web.bind.annotation.*;
import com.example.StudentDetails.model.Student;
import java.util.*;
@RestController
@RequestMapping("/students")


public class StudentController {
    public StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student){
        return studentService.registerStudent(student);
    }
    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "Student with id " + id + " deleted successfully.";
    }
}
