package com.codingdojo.crud.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.codingdojo.crud.models.Langs;

@Service
public class LangService {
private ArrayList<Langs> langs = new ArrayList<Langs>();
	
	public void addLang(Langs lang) {
		langs.add(lang);
	}
 public ArrayList<Langs> allLangs() {
	 return langs;
 }
 
 public Langs getlanguage(int index) {
	return langs.get(index);
 }
 public void updateLang(int  index,Langs lang) {
	 if(index < langs.size()) {
		langs.set(index, lang) ;
	 }
	//lang = langs.get(index);
 }
 
 public void delLang(int index) {
	 if(index < langs.size()) {
	 langs.remove(index);
	 }
 }

}
