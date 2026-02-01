package com.example.Student_Databse_APIs.service;

import com.example.Student_Databse_APIs.UserLoginDTO;
import com.example.Student_Databse_APIs.entity.Student;
import com.example.Student_Databse_APIs.exeption.PhoneNumberValidation;
import com.example.Student_Databse_APIs.repository.StudentRepository;
import com.example.Student_Databse_APIs.response.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    // CRUD (create, read, update, delete) operations will be implemented here

    // Add student
    public ApiResponse<Student> addStudent(Student student){
        if(!student.getPhoneNumber().startsWith("+880")){
            throw new PhoneNumberValidation("Phone number must start with +880");
        }

        if(!student.getEmail().contains("@")){
            throw new RuntimeException("You must enter a valid email");
        }
        ApiResponse<Student> response = new ApiResponse<>(
                HttpStatus.OK.toString(),
                200,
                "Student added successfully",
                false,
                student
        );
        return response;
    }

    // Get all student
    public Page<Student> getAllStudents(Pageable pageable){
        return repository.findAll(pageable);
    }

    // Get student by Id
    public Student getStudentById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found for this id"));
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
                .orElseThrow(() -> new RuntimeException("Student not found for - " + classRoll));
    }

    // Find student by address
    public Student findStudentByAddress(String address){
        return repository.findStudentByAddress(address)
                .orElseThrow(() -> new RuntimeException("Student not found for - " + address));
    }

    public UserLoginDTO login(UserLoginDTO userLoginDTO) {
        return userLoginDTO;
    }
}
