package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class UserService 
{
	//@Autowired is used To inject Object dependency
	@Autowired
	private UserRepository ur;
	
		//Add Or Update
		public void save(User user)
		{
			ur.save(user);
		}
		//delete
		public void delete(Integer id)
		{
			ur.deleteById(id);
		}
		//retrieve
		public User get(Integer id)
		{
			return ur.findById(id).get();
		}
		//retrieve all the Data
		public List<User> ListAll()
		{
			return ur.findAll();
		}

}
