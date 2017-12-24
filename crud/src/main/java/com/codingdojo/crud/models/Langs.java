package com.codingdojo.crud.models;

import javax.validation.constraints.Size;

public class Langs {
	@Size(min=2,max=20)
	private String name;
	@Size(min=2,max=20)
	private String creator;
	
	@Size(min = 1,message="Version cannot be empty")
	private String version;
	
	public Langs() {
		
	}

	public Langs(String name,String creator,String version) {
		this.name = name;
		this.creator = creator;
		this.version = version;
	}
	
	public String getName() {
		return name;
	}
	public String getCreator() {
		return this.creator;
	}
	public String getVersion() {
		return this.version;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
}
