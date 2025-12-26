package com.jsp.studentadd.service;

import java.util.List;

import com.jsp.studentadd.entity.Student;

public interface StuService {
	
	Student saveStu(Student student);
	
	Student findByName(String name);

	Student findByCourse(String course);
	
	Student updateStuCourse(String id, String course);
	
	List<Student> fetchAll();
	
	Student updateWholeStudent(String id , Student student);
	
	Student removeStudent(String id);
	
	long deleteAllStudentsAndReturnCount();	
	
	
}
