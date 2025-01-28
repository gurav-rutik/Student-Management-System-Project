package com.jspiders.springboot.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springboot.entity.Student;
import com.jspiders.springboot.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
		
	}

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
		
	}

	public Student updateStudent(Integer id, Student updatedStudent) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		if(optionalStudent.isPresent()) {
			Student student = optionalStudent.get();
			
			student.setName(updatedStudent.getName());
			student.setEmail(updatedStudent.getEmail());
			student.setMobile(updatedStudent.getMobile());
			student.setCourse(updatedStudent.getCourse());
			student.setMarks(updatedStudent.getMarks());
			
			return studentRepository.save(student);
		}else {
			throw new RuntimeException("Student not found!");
		}
	}

	public void addStudent(Integer id) {
		studentRepository.deleteById(id);
		
	}

	public List<Student> sortStudentByMarks(int sortBy) {
		List<Student> studentds = studentRepository.findAll();
		
		Collections.sort(studentds);
		
		if(sortBy == 1) {
			Collections.reverse(studentds);
		}
		
		return studentds;
	}

	public List<Student> findStudentsByCourse(String course) {
		return studentRepository.findStudentsByCourse(course);
		
	}
}
