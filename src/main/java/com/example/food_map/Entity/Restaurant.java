package com.example.food_map.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Restaurant")
public class Restaurant {
	
	@Id // ªí¥Ü¥DÁä
	@Column(name = "id")
	private String id;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "star")
	private int star;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public Restaurant(String id, String city, int star) {
		super();
		this.id = id;
		this.city = city;
		this.star = star;
	}

	public Restaurant(String id, String city) {
		super();
		this.id = id;
		this.city = city;
	}

	public Restaurant() {
	}
	

}
