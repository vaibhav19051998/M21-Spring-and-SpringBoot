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
public class CollegeController 
{
	@Autowired
	private CollegeService cservice;
	
	//RESTful API method to create  operation
	@PostMapping("/colleges")
	public void add(@RequestBody College c)
	{
		cservice.create(c);
	}
	
	//RESTful API method to update  operation
	@SuppressWarnings("unused")
	@PutMapping("colleges/{id}")
	public ResponseEntity<?> update(@RequestBody College c, @PathVariable Integer id)
	{
		try
		{
			College existObject = cservice.retrieve(id);
			cservice.create(c);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (NoSuchElementException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
		
	//RESTful API method to retrieve with specific id operation
	@GetMapping("/colleges/{id}")
	public ResponseEntity<College>get (@PathVariable Integer id)
	{
		try
		{
			College c = cservice.retrieve(id);
			return new ResponseEntity<College>(c,HttpStatus.OK);
		}
		catch (NoSuchElementException e)
		{
			return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
		}		
	}
		
	//RESTful API method to retrieve all operation
	@GetMapping("/colleges")
	public List<College> listAll()
	{
		return cservice.retrieveAll();
	}
		
	//RESTful API method to delete  operation
	@DeleteMapping("/colleges/{id}")
	public void remove(@PathVariable Integer id)
	{
		cservice.delete(id);
	}
}