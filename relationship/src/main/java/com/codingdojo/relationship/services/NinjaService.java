package com.codingdojo.relationship.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.relationship.models.Ninja;
import com.codingdojo.relationship.repositories.NinjaRepository;

@Service
public class NinjaService {
	private NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninja) {
		this.ninjaRepo = ninja;
	}
	
	public Ninja createNinjas(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	public ArrayList<Ninja> allNinjas() {
		return (ArrayList<Ninja>) ninjaRepo.findAll();
	}
	

}
