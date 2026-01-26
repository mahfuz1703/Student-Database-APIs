package com.example.Student_Databse_APIs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // This annotation generates getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor // This annotation generates a constructor with parameters for all fields in the class
@Entity // This annotation specifies that the class is an entity and is mapped to a database table
public class Student {
    @Id // This annotation specifies the primary key of an entity
    @GeneratedValue // This annotation provides for the specification of generation strategies for the values of primary keys
    private Long id;

    private String name;
    private String address;
    private String classRoll;
}
