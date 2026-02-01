package com.example.Student_Databse_APIs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @NotNull(message = "Name cannot be null")
    private String name;


    private String address;

    @NotNull(message = "Class Roll cannot be null")
    private String classRoll;

    @NotNull(message = "Phone Number cannot be null")
//    @Pattern(regexp = "^\\+880\\d{10}$\n", message = "Phone number must be start with +880 and contain 10 digits")
    private String phoneNumber;

//    @Email(message = "Email should be valid")
    @NotNull(message = "Email cannot be null")
    private String email;
}
