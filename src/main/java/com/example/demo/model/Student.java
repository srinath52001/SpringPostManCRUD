package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Controller
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="student_tab")
public class Student {

	
	@Id
	@GeneratedValue
	private Integer rollNo;
	private String name;
	private String dept;
	private Integer marks;
	private Double percentage;
	
	
}
