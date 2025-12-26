package com.jsp.studentadd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.studentadd.entity.Student;
import com.jsp.studentadd.service.StuService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class StuController {

	
	@Autowired
	private StuService service ;
	
	@PostMapping("/student/save")
	private ResponseEntity<Student> add(@Valid @RequestBody Student student){
		return new ResponseEntity<Student>(service.saveStu(student), HttpStatus.CREATED);
	}
	
	@GetMapping("/student/{name}")
	private ResponseEntity<Student> fetchByName(@PathVariable String name){
		return new ResponseEntity<Student>(service.findByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/student/course/{course}")
	private ResponseEntity<Student> fetchByCourse(@PathVariable String course){
		return new ResponseEntity<Student>(service.findByCourse(course), HttpStatus.OK);
	}
	
	@PatchMapping("/student/{id}/{course}")
	private ResponseEntity<Student> updateCourse(@PathVariable String id , @PathVariable String course){
		return new ResponseEntity<Student>(service.updateStuCourse(id, course), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/student/fetchAll")
	private ResponseEntity<List<Student>> fetchAll(){
		return new ResponseEntity<List<Student>> (service.fetchAll(), HttpStatus.OK);
	}
	
	
	@PutMapping("/student/update/{id}")
	private ResponseEntity<Student> updateStudent(@PathVariable String id , @RequestBody Student student){
		return new ResponseEntity<Student>(service.updateWholeStudent(id, student), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/student/delete/{id}")
	private ResponseEntity<Student> deleteStudent(@PathVariable String id){
		return new ResponseEntity<Student>(service.removeStudent(id), HttpStatus.GONE);
	}
	 
	
	@DeleteMapping("/student/deleteAll")
	public ResponseEntity<String> deleteAllStudents() {
		

	    long deletedCount = service.deleteAllStudentsAndReturnCount();

	    return ResponseEntity.ok(deletedCount + " students deleted");
	}

	
}
