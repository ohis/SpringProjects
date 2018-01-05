package com.codingdojo.relationship.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="ninjas")
public class Ninja {
 @Id
 @GeneratedValue
 Long id;
 private String firstName;
 private String lastName;
 private int age;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="dojos_id1")
 private Dojo dojo;
 public Ninja() {
	 
 }
 public String getfirstName() {
	 return firstName;
 }
 public void setfirstName(String firstname) {
	 this.firstName = firstname;
 }
 public String getlastName() {
	 return lastName;
 }
 public void setlastName(String lastName) {
	 this.lastName = lastName;
 }
 public int getAge() {
	 return age;
 }
 public void setAge(int age) {
	 this.age = age;
 }
 public Date getcreatedAt() {
	 return createdAt;
 }
 public void setcreatedAt(Date created) {
	 this.createdAt = created;
 }
 public Date getupdatedAt() {
	 return updatedAt;
 }
 public void setupdatedAt(Date updated) {
	 this.updatedAt = updated;
 }
 public Dojo getDojo() {
	 return dojo;
 }
 public void setDojo(Dojo dojo) {
	 this.dojo = dojo;
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
