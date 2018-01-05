package com.codingdojo.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="songs")
public class Song {
	@Id
	@GeneratedValue
	
	private Long id;
	
	@Column(name="title")
	@Size(min=5 , message="Title must be greater than 5 characters in length")
	private String title;
	
	@Column(name="artist")
	@Size(min=5)
	private String artist;
	
	@Column(name="rating")
	@NotNull(message="Rating must be present")
	private Integer rating;
	
	@Column(updatable=false)
	
	private Date createdAt;
	
	private Date updatedAt;
	
	public Song() {
		
	}
	
	public Song(String title,String artist, int rating,Date create,Date update) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		this.createdAt = create;
		this.updatedAt = update;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return this.artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public Integer getRating() {
		return this.rating;
	}
	public void setRating(Integer rate) {
		this.rating = rate;
	}
	public void setID(Long id) {
		this.id = id;
	}
	public Long getID() {
		return id;
	}
	
	public Date getCreateAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date create) {
		this.createdAt = create;
	}
	
	public Date getUpdated() {
		return updatedAt;
	}
    public void setUpdated(Date update) {
    	this.updatedAt = update;
    }
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
