package com.example.food_map.vo;

import java.util.List;

import com.example.food_map.Entity.Restaurant;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantResponse {
	
	@JsonProperty("restaurant")
	private Restaurant restaurant;
	
	
	@JsonProperty("restaurant_list")	
	private List<Restaurant> restaurantList;
	
	
	private String id;
	
	private String city;
	
	private int star;
	
	private String message;
	
	public  RestaurantResponse() {
		
	}
	
	

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



	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}



	public List<Restaurant> getRestaurantList() {
		return restaurantList;
	}

	public void setRestaurantList(List<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	public RestaurantResponse(String message) {
		super();
		this.message = message;
	}

	public RestaurantResponse(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public RestaurantResponse(List<Restaurant> restaurantList, String message) {
		this.restaurantList = restaurantList;
		this.message = message;
	}



	public RestaurantResponse(String id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	

}
