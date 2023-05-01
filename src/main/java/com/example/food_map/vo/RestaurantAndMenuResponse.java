package com.example.food_map.vo;

import java.util.List;

import com.example.food_map.Entity.Restaurant;
import com.example.food_map.Entity.RestaurantAndMenu;
import com.example.food_map.Entity.responseRestAndMenu;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantAndMenuResponse {
	
	@JsonProperty("RestaurantAndMenu")
	private RestaurantAndMenu restaurantAndMenu;
	
	@JsonProperty("RestaurantAndMenu_list")
	private List<RestaurantAndMenu> RestaurantAndMenuList;
	
	private String id;
	
	private String city;
	
	private double star;
	
	private String message;
	
	private String storeName;
	
	private String storeMenu;
	
	private Integer price;
	
	private Integer menustar;
	
	

	public RestaurantAndMenuResponse() {

	}

	public RestaurantAndMenu getRestaurantAndMenu() {
		return restaurantAndMenu;
	}

	public void setRestaurantAndMenu(RestaurantAndMenu restaurantAndMenu) {
		this.restaurantAndMenu = restaurantAndMenu;
	}

	public List<RestaurantAndMenu> getRestaurantAndMenuList() {
		return RestaurantAndMenuList;
	}

	public void setRestaurantAndMenuList(List<RestaurantAndMenu> restaurantAndMenuList) {
		RestaurantAndMenuList = restaurantAndMenuList;
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
	

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreMenu() {
		return storeMenu;
	}

	public void setStoreMenu(String storeMenu) {
		this.storeMenu = storeMenu;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getMenustar() {
		return menustar;
	}

	public void setMenustar(Integer menustar) {
		this.menustar = menustar;
	}

	public RestaurantAndMenuResponse(String message) {
		super();
		this.message = message;
	}

	public RestaurantAndMenuResponse(String id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	
	

	public RestaurantAndMenuResponse(Integer star, String message) {
		super();
		this.star = star;
		this.message = message;
	}

	public RestaurantAndMenuResponse(List<Restaurant> infoList, String string) {
		// TODO Auto-generated constructor stub
		this.message = string;
	}

	public RestaurantAndMenuResponse(String string, List<responseRestAndMenu> reRAML) {
		// TODO Auto-generated constructor stub
	}




	
	
	
	
	
	
	
	

}
