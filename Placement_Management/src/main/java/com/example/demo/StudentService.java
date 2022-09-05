package com.example.demo;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentService 
{
	//@Autowired is used To inject Object dependency
	@Autowired
	private StudentRepository sr;
	
	//Create Or Insert Or Update
	public void create(Student student)
	{
		sr.save(student);
	}
	//retrieve
	public Student retrieve(Integer id)
	{
		return sr.findById(id).get();
	}
	//retrieve all the Data
	public List<Student>retrieveAll()
	{
		return sr.findAll();
	}
	//delete
	public void delete(Integer id)
	{
		sr.deleteById(id);
	}

}
