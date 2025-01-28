package com.jspiders.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private long mobile;
	private String course;
	private double marks;
	
	@Override
	public int compareTo(Student o) {
		if(this.marks == o.marks) {
			return 0;
		}else if(this.marks>o.marks) {
			return 1;
		}else {
			return -1;
		}
	}
}
