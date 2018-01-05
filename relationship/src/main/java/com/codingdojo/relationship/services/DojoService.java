package com.codingdojo.relationship.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.codingdojo.relationship.models.Dojo;
import com.codingdojo.relationship.repositories.DojoRepository;

@Service
public class DojoService {
	private DojoRepository dojoRepo;
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	public void createDojo(Dojo dojo) {
		 dojoRepo.save(dojo);
	}
	public ArrayList<Dojo> alldojos(){
		return (ArrayList<Dojo>) dojoRepo.findAll();
	}
	public Dojo getDojo(Long id) {
		return dojoRepo.findOne(id);
	}

}
