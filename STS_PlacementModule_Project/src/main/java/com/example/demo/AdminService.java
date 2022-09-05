package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdminService 
{
		@Autowired // to inject object dependency
		private AdminRepository repo;
		//Create or Insert Or Update
		public void create(Admin a)
		{
			repo.save(a);
		}
		//retrieve
		public Admin retrieve(Integer id)
		{
			return repo.findById(id).get();
		}
		//retrieve All the data
		public List<Admin>retrieveAll()
		{
			return repo.findAll();
		}
		//delete
		public void delete(Integer id)
		{
			repo.deleteById(id);
		}

	}