package com.coffeeshop.api.service;

import com.coffeeshop.api.domain.Person;
import com.coffeeshop.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public List<Person> findByEmail(String email) {
		return personRepository.findByEmail(email);
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public List<Person> findByEmailAndPassword(String email, String password) {
		return personRepository.findByEmailAndPassword(email, password);
	}

	public Person findById(Long id) {
		return personRepository.findOne(id);
	}

	public void removePerson(Person person) {
		personRepository.delete(person);
	}

}
