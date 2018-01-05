package com.codingdojo.relationships.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="licenses")
public class License {
  @Id
  @GeneratedValue
  private Long id;
  
  
  private String number;
  
  
  private Date expirationDate;
  
 
  private String state;
  @Column(updatable=false)
  private Date createdAt;
  private Date updatedAt;
  @OneToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="persons_id")
  private Person person;
  
  public License() {
	  
  }
  //public License(String number,Date expiration,String state,Date create,Date update) {
	  //this.state = state;
	 // this.expirationDate = expiration;
	  //this.person = person;
	  //this.createdAt = create;
	 // this.updatedAt = update;
	//  this.number = number;
 // }
  public String getNumber() {
    return number;
}
  public void setNumber(String number) {
	  this.number = number;
  }
  public String getState() {
	  return state;
  }
  public void setState(String state) {
	  this.state = state;
	  
  }
  public Date getExpirationDate() {
	  return expirationDate;
  }
  public void setExpirationDate(Date expirationDate) {
	  this.expirationDate = expirationDate;
  }
  public Long getID() {
	  return id;
  }
  public void setID(Long id) {
	  this.id = id;
  }
  public Date getCreatedAt() {
	  return this.createdAt;
  }
  public void setCreatedAt(Date create) {
	  this.createdAt = create;
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
  public Person getPerson() {
	  return person;
  }
  public void setPerson(Person person) {
	  this.person = person;
  }
}