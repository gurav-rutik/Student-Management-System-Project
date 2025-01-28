package com.jspiders.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.entity.Student;
import com.jspiders.springboot.service.StudentService;

@RestController
@RequestMapping(path = "api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	protected Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@GetMapping
	protected List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	@PutMapping("/{id}")
	protected Student updateStudent(@PathVariable Integer id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}
	
	@DeleteMapping("/{id}")
	protected void deleteStudent(@PathVariable Integer id) {
		studentService.addStudent(id);
	}
	
	
	@GetMapping("/sort/{sortBy}")
	protected List<Student> sortStudentByMarks(@PathVariable int sortBy) {
		return studentService.sortStudentByMarks(sortBy);
	}
	
	@GetMapping("/find/{course}")
	protected List<Student> findStudentsByCourse(@PathVariable String course) {
		return studentService.findStudentsByCourse(course);
	}
}
