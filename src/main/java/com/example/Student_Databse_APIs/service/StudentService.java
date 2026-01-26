package com.example.Student_Databse_APIs.service;

import com.example.Student_Databse_APIs.entity.Student;
import com.example.Student_Databse_APIs.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    // CRUD (create, read, update, delete) operations will be implemented here

    // Add student
    public Student addStudent(Student student){
        return repository.save(student);
    }

    // Get all student
    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    // Get student by Id
    public Student getStudentById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found for this id"));
    }

    // Update student by id
    public Student updateStudentById(Long id, Student student){
        Student std = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setId(std.getId());
        repository.save(student);
        return student;
    }

    // Delete student by id
    public void deleteStudentById(Long id){
        repository.deleteById(id);
    }

    // Find student by classRoll
    public Student findByClassRoll(String classRoll){
        return repository.findByClassRoll(classRoll)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // Find student by address
    public Student findStudentByAddress(String address){
        return repository.findStudentByAddress(address)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
