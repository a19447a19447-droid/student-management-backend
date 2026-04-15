package com.example.student_management.domain;

import jakarta.persistence.*;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_seq")
	@SequenceGenerator(name = "student_id_seq", sequenceName = "student_id_seq", allocationSize = 1)
	private Long id;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(length = 50)
	private String surname;

    // Standard Getters and Setters (Fixes the Javac Processor Error)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
}