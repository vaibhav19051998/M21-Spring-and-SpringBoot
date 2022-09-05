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
public class PlacementController 
{
	@Autowired
	private PlacementService service;
	
	//RESTful API method to create  operation
	@PostMapping(path="/placements")
	public void add(@RequestBody Placement p)
	{
		service.create(p);
	}
	
	//RESTful API method to delete  operation
		@DeleteMapping("/placements/{id}")
		public void remove(@PathVariable Integer id)
		{
			service.delete(id);
		}
	
	//RESTful API method to update  operation
	@SuppressWarnings("unused")
	@PutMapping("/placements/{id}")
	public ResponseEntity<?> update(@RequestBody Placement p, @PathVariable Integer id)
	{
		try
		{
			
			Placement existObject = service.retrieve(id);
			service.create(p);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (NoSuchElementException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	//RESTful API method to retrieve with specific id operation
	@GetMapping(path="/placements/{id}")
	public ResponseEntity<Placement>get (@PathVariable Integer id)
	{
		try
		{
			Placement p = service.retrieve(id);
			return new ResponseEntity<Placement>(p,HttpStatus.OK);
		}
		catch (NoSuchElementException e)
		{
			return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
		}		
	}
	
	//RESTful API method to retrieve all operation
	@GetMapping("/placements")
	//public List<Placement> listAll()
	public List<Placement> retrieveAll()
	{
		return service.retrieveAll();
	}
			
	
}