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

public class AdminController {
	@Autowired
	private AdminService Service;
	//RESTFUL API method for Create operation
	@PostMapping("Admins")
	public void add(@RequestBody Admin a)
	{
		Service.create(a);
	}
	//RESTFUL API method for delete operation
	@DeleteMapping("Admins")
	public void remove(@PathVariable Integer id)
	{
		Service.delete(id);
	}
	
	//RESTFUL API method for update operation
	@PutMapping("Admin")
	public ResponseEntity<?> update(@RequestBody Admin a,@PathVariable Integer id)
	{
		try
		{
			@SuppressWarnings("unused")
			Admin existObject=Service.retrieve(id);
			Service.create(a);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
		//RESTFUL API method for retrieve operation
		@GetMapping("/Admins/(id)")
		public ResponseEntity<Admin> get(@PathVariable Integer id)
		{
			try
			{
				
				Admin a =Service.retrieve(id);
				return new ResponseEntity<Admin>(a,HttpStatus.OK);
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
			}
			
			
		}
		//RESTFUL API method for retrieveAll operation
		@GetMapping("/Admins")
		public List<Admin>listAll()
		{
			return Service.retrieveAll();
		}
	
}
