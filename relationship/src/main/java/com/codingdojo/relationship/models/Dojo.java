package com.codingdojo.relationship.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="dojos")
public class Dojo {
  @Id
  @GeneratedValue
 private Long id;
  private String name;
  @Column(updatable=false)
  private Date createdAt;
  private Date updatedAt;
  @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
  private List<Ninja> ninjas;
  
  public Dojo() {
	  
  }
  public String getName() {
	  return name;
  }
  public void setName(String name) {
	  this.name = name;
  }
  public Long getID() {
	  return id;
  }
  public void setID(Long id) {
	  this.id = id;
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
  public void setupdatedAt(Date update) {
	  this.updatedAt = update;
  }
  public List<Ninja> getNinjas() {
	  return  ninjas;
  }
  public void setNinja(List<Ninja> ninja) {
	  this.ninjas = (List<Ninja>) ninja;
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
