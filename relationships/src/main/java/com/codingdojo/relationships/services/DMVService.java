package com.codingdojo.relationships.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.LicenseRepository;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class DMVService {
	private final LicenseRepository licenseR;
	private final PersonRepository personRepo;
		public DMVService(PersonRepository personR,LicenseRepository lr) {
			this.personRepo = personR;
			this.licenseR = lr;
			
		}
		public License addLicense(License l) {
			return licenseR.save(l);
		}
		
		
		 
		 //public PersonServices(PersonRepository personR) {
		//	 this.personRepo = personR;
		// }
		 
		 public void addPerson(Person person) {
			 personRepo.save(person);
		 }
		 public ArrayList<Person> allPeople() {
			 return (ArrayList<Person>) personRepo.findAll();
		 }
		 
		 public Person getPerson(Long id) {
			 return personRepo.findOne(id);
		 }


}
