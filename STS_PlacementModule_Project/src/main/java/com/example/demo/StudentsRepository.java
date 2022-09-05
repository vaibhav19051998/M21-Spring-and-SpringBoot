package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This repository exists in Spring Data JPA dependencies while creating the spring starter project 
@Repository
public interface StudentsRepository extends JpaRepository<StudentsClass,Integer>
{

}
