package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;


//JpaRepository is exists in string Data JPA dependencies while creating the project we have added it

public interface UserRepository extends JpaRepository<User,Integer>
{

}
