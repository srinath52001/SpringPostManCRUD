package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Student;
import com.example.demo.serviceImpl.ServiceInterface;


@Controller
public class StudentController {

	@Autowired
	private ServiceInterface service;
		
	@PostMapping("/create")
	public ResponseEntity<Student> studentsData(@RequestBody Student student)
	{

		Student res = service.insertData(student);

		
		return new ResponseEntity<Student>(res,HttpStatus.OK);
	}
	
	@GetMapping("/select")
	public ResponseEntity<List<Student>> studentRetrieveData(Model model)
	{
		List<Student> stu = service.studentDataRetrieveInterface();
		return new ResponseEntity<List<Student>>(stu,HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{rollNo}")
	public ResponseEntity<String> studentUpdate(@PathVariable Integer rollNo,@RequestBody Student student) {
		
		
		boolean stuu = service.studentUpdateInterface(student, rollNo);
		if(stuu) {
		
		return new ResponseEntity<String>("your data has been updates",HttpStatus.OK); 
		}
		return new ResponseEntity<String>("No data fond",HttpStatus.OK); 
	}
	
	
	// delete by Id
	@DeleteMapping("/delete/{rollNo}")
	public ResponseEntity<String> studentDelete(@PathVariable Integer rollNo, @ModelAttribute Student student)
	{
		
		boolean res = service.studentDelete(student, rollNo);
		
		if(res) {
		return new ResponseEntity<String>("Your data as been deleted sucessfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("No data found",HttpStatus.OK);
	}
	
	
	// for retrieveing 1 record
	@GetMapping("/retrieve/{rollNo}")
	public ResponseEntity<Optional<Student>> studentretrieveRecord(@PathVariable Integer rollNo){
		
		Optional<Student> res = service.singleRecordRetieve(rollNo);
		
		return new ResponseEntity<Optional<Student>>(res,HttpStatus.OK);
		
	}

	

	// delete All
	@DeleteMapping("/deleteall")
	public ResponseEntity<String> studentDelete()
	{
		service.studentDeleteAll();
		return new ResponseEntity<String>("Your data has been deleted sucessfully",HttpStatus.OK);
	}
}
