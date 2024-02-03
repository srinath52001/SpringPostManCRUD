package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentRepository;
import com.example.demo.model.Student;

@Service
public class ServiceImple  implements ServiceInterface{

	
	@Autowired
	private StudentRepository repo;
	
	
	//for inserting data
	@Override
	public Student insertData(Student student) {
	
		Integer marks  = student.getMarks();
		double per = (marks*100)/150;
		student.setPercentage(per);
		
		return repo.save(student);
	}
	

	//for retrieval
	@Override
	public 	List<Student> studentDataRetrieveInterface()
 {
		
		return repo.findAll();
		
	}

	
	
	// for updating
	@Override
	public boolean studentUpdateInterface(Student student,Integer rollNo) {
		
		if(repo.existsById(rollNo))
		{
			Integer marks  = student.getMarks();
			double per = (marks*100)/150;
			student.setPercentage(per);
			
			student.setRollNo(rollNo);
			
		 repo.save(student);
		return true;
		}
		return false;
		
		
	}
	
	
	//for Deleting
	@Override
	public boolean studentDelete(Student student, Integer rollNo)
	{
		if(repo.existsById(rollNo))
		{
		repo.deleteById(rollNo);
		return true;
		}
		return false;
}


	@Override
	public Optional<Student> singleRecordRetieve(Integer rollNo) {
		
		if(repo.existsById(rollNo))
		{
		Optional<Student> res = repo.findById(rollNo);
		return res;
		}
		return null;
	}


	// for deleting all rows
	@Override
	public void studentDeleteAll() {
		repo.deleteAll();
	}



}
