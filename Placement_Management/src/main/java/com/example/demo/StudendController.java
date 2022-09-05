package com.example.demo;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudendController
{
	@Autowired
	private StudentService service;

	//RESTFUL API method to create operation
	@PostMapping("/stud")
	public void add(@RequestBody Student student)
	{
		service.create(student);
	}
	//RESTFUL API method to delete operation
	@DeleteMapping("/stud/{id}")
	 public void remove(@PathVariable Integer id)
	 {
		 service.delete(id);
	 }
	//RESTFUL API method to update operation
	@PutMapping("stud/{id}")
	public ResponseEntity<?> update(@RequestBody Student student,@PathVariable Integer id)
	{
		try
		{
			@SuppressWarnings("unused")
			Student existObject=service.retrieve(id);
			service.create(student);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//RESTFUL API method to retrieve operation
	@GetMapping("/stud/{id}")
	public ResponseEntity<Student>get(@PathVariable Integer id)
	{

		try
		{
			@SuppressWarnings("unused")
			Student student=service.retrieve(id);
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	//RESTFUL API method to retrieveAll operation
	@GetMapping("/stud")
	public List<Student>listAll()
	{
		return service.retrieveAll();
	}
}
