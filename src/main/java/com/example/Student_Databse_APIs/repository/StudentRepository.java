package com.example.Student_Databse_APIs.repository;

import com.example.Student_Databse_APIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // This annotation indicates that the class is a repository and will handle data operations
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByClassRoll(String classRoll);

    // Find student by address with JPQL (Java Persist Query Language)
    @Query("SELECT s FROM Student s WHERE s.address LIKE %:keyword%")
    Optional<Student> findStudentByAddress(String keyword);
}
