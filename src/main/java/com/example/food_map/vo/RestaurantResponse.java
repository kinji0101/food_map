package com.example.food_map.vo;

import java.util.List;

import com.example.food_map.Entity.Restaurant;
import com.example.food_map.Entity.responseRestAndMenu;
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
	
	private Integer star;
	
	private String message;
	
	@JsonProperty("rest_and_menu_list")
	private List<responseRestAndMenu> rRAM;
	
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



	public Integer getStar() {
		return star;
	}



	public void setStar(Integer star) {
		this.star = star;
	}

	public List<responseRestAndMenu> getrRAM() {
		return rRAM;
	}

	public void setrRAM(List<responseRestAndMenu> rRAM) {
		this.rRAM = rRAM;
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

	public RestaurantResponse(String message, List<responseRestAndMenu> rRAM) {
		this.message = message;
		this.rRAM = rRAM;
	}
	
}
