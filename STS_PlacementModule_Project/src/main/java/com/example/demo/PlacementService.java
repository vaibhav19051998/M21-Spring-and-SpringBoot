package com.example.demo;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PlacementService 
{
	@Autowired//to inject object dependency
	private PlacementRepository pao;
	// create or insert or update
		public void create(Placement p)
		{
			pao.save(p);
		}
		
		//retrieve a data with specific id
		public Placement retrieve(Integer id)
		{
			return pao.findById(id).get();
		}
		
		//retrieve all data
		public List<Placement>retrieveAll()
		{
			return pao.findAll();
		}
		
		//delete
		public void delete(Integer id)
		{
			pao.deleteById(id);
		}
}