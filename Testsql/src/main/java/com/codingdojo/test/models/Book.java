package com.codingdojo.test.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {
	@Id
	
	@GeneratedValue
	private Long id;
	@Column(name="titles")
	@Size(min = 3,max = 20)
    private String title;
	
	@Column(name="descriptions")
	@Size(min = 5,max = 200)
    private String description;
	
	@Column(name="lans")
	@Size(min = 3, max = 40)
    private String language;
	
	@Column(name="pages")
	@Min(100)
    private int numberOfPages;
    
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	
	private Date createdAt;
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	
	private Date updatedAt;
    public Book() {
    	
    }
    
    
    public Book(String title, String desc,String lang,int pages,Date create,Date update) {
    	this.title = title;
    	this.description = desc;
    	this.language = lang;
    	this.numberOfPages = pages;
    	this.createdAt = create;
    	this.updatedAt = update;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    
    public Long getID() {
    	return id;
    }
    public void setID(Long id) {
    	this.id = id;
    }
    public Date getCreatedAT() {
    	return createdAt;
    }
    public void setCreatedAT(Date d) {
    	this.createdAt = d;
    }
    public Date getUpdatedAt() {
    	return updatedAt;
    }
    public void setUpdatedAt(Date update) {
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
