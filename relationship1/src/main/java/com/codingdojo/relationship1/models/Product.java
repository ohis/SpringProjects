package com.codingdojo.relationship1.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
@Id
@GeneratedValue
private Long id;
private String name;
private String description;
private float price;
@Column(updatable=false)
private Date createdAt;
private Date updatedAt;
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(
	name = "categories_products",
	joinColumns = @JoinColumn(name = "products_id"),
	inverseJoinColumns = @JoinColumn(name = "categories_id")
		)
private List<Category> categories;
public Product() {
	
}
}
