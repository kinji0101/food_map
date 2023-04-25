package com.example.food_map.vo;

import java.util.List;

import com.example.food_map.Entity.RestaurantAndMenu;
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
	
	private int star;
	
	private String message;
	
	private String storeName;
	
	private String storeMenu;
	
	private Integer price;
	
	private Integer menustar;

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

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
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
	
	
	
	
	
	

}
