package com.jsp.studentadd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.studentadd.entity.Student;
import com.jsp.studentadd.exception.NoDataFoundException;
import com.jsp.studentadd.exception.ResourceAlreadyException;
import com.jsp.studentadd.exception.ResourceNotFoundException;
import com.jsp.studentadd.repository.StuRepo;

import jakarta.transaction.Transactional;


@Service
public class StuServiceImpli implements StuService 
{

	@Autowired
	private StuRepo repo;
	
	@Override
	public Student saveStu(Student student) {
		 if(student.getId() != null && repo.existsById(student.getId())) {
			 throw new ResourceAlreadyException(student.getId() + " id object already exist in the database");
		 }
		 return repo.save(student);
	}

	@Override
	public Student findByName(String name) {
		
		Optional<Student> optional = repo.findByName(name);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		throw new ResourceNotFoundException(name + " name is not present in the database.");
	
	
	}

	@Override
	public Student findByCourse(String course) {
		 Optional<Student> optional = repo.findByCourse(course);
		 
		 if(optional.isPresent()) {
			 return optional.get();
					 
		 }
		 
		 throw new ResourceNotFoundException(course + " course is not present in the database.");
	}

	@Override
	public Student updateStuCourse(String id, String course) {
		 if (!repo.existsById(id)) {
		        throw new ResourceNotFoundException("Student with id " + id + " not found");
		    }

		    Student student = repo.findById(id).get();  
		    student.setCourse(course);

		    return repo.save(student);
	}

	@Override
	public List<Student> fetchAll() {
		 List<Student> list = repo.findAll();
		 return list;
	}

	@Override
	public Student updateWholeStudent(String id, Student student) {
		if (!repo.existsById(id)) {
	        throw new ResourceNotFoundException("Student with id " + id + " not found");
	    }
		
		Student student2 = repo.findById(id).get();
		student2.setName(student.getName());
		student2.setAge(student.getAge());
		student2.setAddress(student.getAddress());
		student2.setCourse(student.getCourse());
		
		return repo.save(student2);
	}

	@Override
	public Student removeStudent(String id) {
		
		if (!repo.existsById(id)) {
	        throw new ResourceNotFoundException("Student with id " + id + " not found");
	    }

		Student student = repo.findById(id).get();
		 repo.delete(student);
		 return student;
	}

	 	@Override
	    @Transactional
	    public long deleteAllStudentsAndReturnCount() {

	        long count = repo.count();   
	        
	        if (count == 0) {
	            throw new NoDataFoundException("No students present to delete");
	        }
	        
	        repo.deleteAllInBatch();      

	        return count;                       
	    }

}
