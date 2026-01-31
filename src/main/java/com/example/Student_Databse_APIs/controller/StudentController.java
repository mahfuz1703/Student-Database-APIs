package com.example.Student_Databse_APIs.controller;

import com.example.Student_Databse_APIs.entity.Student;
import com.example.Student_Databse_APIs.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    // Add student
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    // Get all students
    @GetMapping
    public ResponseEntity<Page<Student>> getAllStudents(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok(studentService.getAllStudents(pageable));
    }

    // Get student by id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        if(studentService.getStudentById(id) == null){
            throw new EntityNotFoundException("Student not found for id - " + id);
        }
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // Update student by id
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable Long id, @RequestBody Student student){
        return ResponseEntity.ok(studentService.updateStudentById(id, student));
    }

    // Delete student by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }

    // Find student by classRoll
    @GetMapping("/roll/{classRoll}")
    public  ResponseEntity<Student> findByClassRoll(@PathVariable String classRoll){
        return ResponseEntity.ok((studentService.findByClassRoll(classRoll)));
    }

    // Find student by address
    @GetMapping("/address/{address}")
    public ResponseEntity<Student> findStudentByAddress(@PathVariable String address){
        return ResponseEntity.ok(studentService.findStudentByAddress(address));
    }
}
