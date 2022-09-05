package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  
@Transactional
public class CollegeService 
{
	@Autowired // to inject object dependencies
	private CollegeRepository crepo;
	// create or insert or update
		public void create(College c)
		{
			crepo.save(c);
		}
		
		//retrieve a data with specific id
		public College retrieve(Integer id)
		{
			return crepo.findById(id).get();
		}
		
		//retrieve all data
		public List<College> retrieveAll()
		{
			return crepo.findAll();
		}
		
		//delete
		public void delete(Integer id)
		{
			crepo.deleteById(id);
		}
}
