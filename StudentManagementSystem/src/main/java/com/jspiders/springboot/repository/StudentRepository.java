package com.jspiders.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.springboot.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Optional<Student> findById(Integer id);
	
	void deleteById(Integer id);

	List<Student> findStudentsByCourse(String course);
}
