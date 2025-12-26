package com.jsp.studentadd.entity;

import org.hibernate.annotations.GenericGenerator;

import com.jsp.studentadd.configuration.StuCustomId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(generator  = "emp_id")
	@GenericGenerator(name="emp_id",type  = StuCustomId.class)
	private String id ;
	
	private String name ;
	
	private int age ;
	
	private String course ;
	
	private String address ;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, String course, String address) {
		this.name = name;
		this.age = age;
		this.course = course;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
