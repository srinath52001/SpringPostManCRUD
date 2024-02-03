package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.model.Student;

@Component
public interface ServiceInterface {

	Student insertData(Student student); // for insert data 

	List<Student> studentDataRetrieveInterface(); // for retrieve data
	
	boolean studentUpdateInterface(Student student, Integer rollNo); // for updating 
	
	boolean studentDelete(Student student, Integer rollNo); // for deletion
	
	Optional<Student> singleRecordRetieve(Integer rollNo); // for retrieveing single record

	void studentDeleteAll(); // for deleting all rows

	
}
 