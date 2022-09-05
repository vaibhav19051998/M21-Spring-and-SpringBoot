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
public class StudentsController {
	
	@Autowired
	private StudentsService service;
	
		//RESTFul API method to create operation
		@PostMapping(path="/student")
		public void add(@RequestBody StudentsClass s)
		{
			service.create(s);
		}
		
		//RESTFul API method to delete operation
		@DeleteMapping("/student/{id}")
		public void remove(@PathVariable Integer id)
		{
			service.delete(id);
		}
		
		//RESTFUL API method for update operation
		@PutMapping("/student/{id}")
		public ResponseEntity<?> update(@RequestBody StudentsClass s,@PathVariable Integer id)
		{
			try
			{
				@SuppressWarnings("unused")
				StudentsClass existObject=service.retrieve(id);
				service.create(s);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		//RESTFul API method for retrieve operation
		@GetMapping(path="/student/{id}")
		public ResponseEntity<StudentsClass> get(@PathVariable Integer id)
		{
			try
			{
				StudentsClass s=service.retrieve(id);
				return new ResponseEntity<StudentsClass>(s,HttpStatus.OK);
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<StudentsClass>(HttpStatus.NOT_FOUND);
			}
		}
		
		//RESTFul API method for retrieveAll operation
		
		@GetMapping("/student")
		public List<StudentsClass>retrieveAll()
		{
			return service.retrieveAll();
		}
		


}