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
public class UserController
{
	@Autowired
	private UserService service;
	
		//RESTFUL API method to create operation
		@PostMapping("/users")
		public void add(@RequestBody User user)
		{
			service.save(user);
		}
		//RESTFUL API method to delete operation
		@DeleteMapping("/users/{id}")
		 public void delete(@PathVariable Integer id)
		 {
			 service.delete(id);
		 }
		//RESTFUL API method to update operation
		@PutMapping("users/{id}")
		public ResponseEntity<?> update(@RequestBody User user,@PathVariable Integer id)
		{
			try
			{
				@SuppressWarnings("unused")
				User nu=service.get(id);
				service.save(user);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		//RESTFUL API method to retrieve operation
		@GetMapping("/users/{id}")
		public ResponseEntity<User>get(@PathVariable Integer id)
		{

			try
			{
				@SuppressWarnings("unused")
				User user=service.get(id);
				return new ResponseEntity<User>(user,HttpStatus.OK);
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
		}
		//RESTFUL API method to retrieveAll operation
		@GetMapping("/users")
		public List<User>list()
		{
			return service.ListAll();
		}


}
