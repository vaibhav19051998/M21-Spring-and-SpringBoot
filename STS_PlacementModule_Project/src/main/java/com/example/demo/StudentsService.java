package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentsService
{
	@Autowired  //To inject object dependancy.
	private StudentsRepository dao;
	
	//Create or insert or update
		public void create(StudentsClass s)
		{
			dao.save(s);
		}
		
		//retrieve
		public StudentsClass retrieve(Integer id)
		{
			return dao.findById(id).get();
		}
		
		//retrieve all the data
		public List<StudentsClass>retrieveAll()
		{
			return dao.findAll();
		}
		
		//delete
		public void delete(Integer id)
		{
			dao.deleteById(id);
		}

}
