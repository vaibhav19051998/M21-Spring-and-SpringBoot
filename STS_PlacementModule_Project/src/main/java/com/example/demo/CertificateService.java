package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



public class CertificateService {
	
	@Autowired // to inject object dependency
	private CertificateRepository repo;
	
	public void create(Certificate c)
	{
		repo.save(c);
	}
	//
	public Certificate retrieve(Integer id)
	{
		return repo.findById(id).get();
	}
	//
	public List<Certificate>retrieveAll()
	{
		return repo.findAll();
	}
	//
	public void delete(Integer id)
	{
		repo.deleteById(id);
	}

	

}