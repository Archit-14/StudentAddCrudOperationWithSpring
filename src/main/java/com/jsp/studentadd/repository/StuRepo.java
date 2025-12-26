package com.jsp.studentadd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.studentadd.entity.Student;


@Repository
public interface StuRepo extends JpaRepository<Student, String>
{

	boolean existsById(String id);
	
	Optional<Student> findByName(String name);
	
	Optional<Student> findByCourse(String course);

}
