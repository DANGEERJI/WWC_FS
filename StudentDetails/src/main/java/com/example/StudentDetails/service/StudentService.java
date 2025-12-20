package com.example.StudentDetails.service;
import java.util.*;
import com.example.StudentDetails.model.Student;
import org.springframework.stereotype.Repository;
import com.example.StudentDetails.service.StudentService;
import org.springframework.stereotype.Service;

@Service

public class StudentService {
    private Map<Integer, Student> studentMap = new HashMap<>();

    public Student registerStudent(Student student){
        studentMap.put(student.getId(), student);
        return student;
    }

    public List<Student> getAllStudents(){
        return new ArrayList<>(studentMap.values());
    }

    public Student getStudentById(int id){
        return studentMap.get(id);
    }

    public Student updateStudent(int id, Student student){
        studentMap.put(id, student);
        return student;
    }

    public void deleteStudent(int id){
        studentMap.remove(id);
    }
}
