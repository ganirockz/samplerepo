package com.luv2code.restpractice.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.restpractice.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	
	private List<Student> studentList;
	
	@PostConstruct
	public void loadStudentData() {
		
		studentList = new ArrayList<Student>();

		Student student1 = new Student("Ganesh","Rapeti");
		
		Student student2 = new Student("Navya","Rapeti");
		
		Student student3 = new Student("Sai","Rapeti");
		
		Student student4 = new Student("Dhanush","Rapeti");
		
		Student student5 = new Student("Sunil", "Rapeti");
		
		
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);
		studentList.add(student5);
	}
	
	// create an endpoint or api/students - to get all student data
	
	@GetMapping("/students")
	public List<Student> getStudentsList(){
		return studentList;
	}
	
	// create an endpoint or api/students/{studentId} - to get student data at index studentId
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if((studentId >= this.studentList.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student ID not found: "+ studentId);
		}
		
		Student student = studentList.get(studentId);
		System.out.println("Student at index: will be adsde "+ studentId +" is: \n"+ student);
		return student;
	}
	
}
