package com.codingdojo.relationships.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="persons")
public class Person {
 @Id
 @GeneratedValue
 Long id;
 
 
 private String firstName;
 private String lastName;
 
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 
 @OneToOne(mappedBy="person",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
 private License license;
 
 public Person() {
	 
 }
 
 public  String getFirstName() {
	 return this.firstName ;
 }
 public void setFirstName(String firstName) {
	 this.firstName = firstName;
 }
 public String getLastName() {
	 return this.lastName;
 }
 
 public void setLastName(String lastName) {
	 this.lastName = lastName;
 }
 
 public Date getCreated() {
	 return createdAt;
 }
 
 public void setCreated(Date create) {
	 this.createdAt = create;
 }
 public Date getUpdate() {
	 return updatedAt;
 }
 
 public void setUpdated(Date update) {
	 this.updatedAt = update;
 }
 public Long getID() {
	 return id;
 }
 public void setID(Long id) {
	 this.id = id;
 }
 public License getLicense() {
	 return license;
 }
 public void setLicense(License license) {
	 this.license = license;
 }
 
}
