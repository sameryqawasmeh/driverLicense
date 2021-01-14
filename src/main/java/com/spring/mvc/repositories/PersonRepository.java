package com.spring.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.mvc.models.Person;


@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person> findAll();	
}