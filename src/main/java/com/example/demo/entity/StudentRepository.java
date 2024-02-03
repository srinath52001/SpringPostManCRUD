package com.example.demo.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	/*@Modifying
	@Transactional
	@Query("update student_tab s set s.marks=:mark where s.roll_no=:rollNo")
	void updateTable(Integer rollNo, Integer mark);
	*/

}
