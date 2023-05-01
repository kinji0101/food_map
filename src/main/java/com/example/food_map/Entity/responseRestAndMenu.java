package com.example.food_map.Entity;

import java.util.List;

public class responseRestAndMenu {
	Restaurant restaurant;
	
	List<Menu> menuList;

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public responseRestAndMenu() {
		
	}

	public responseRestAndMenu(Restaurant restaurant, List<Menu> menuList) {
		this.restaurant = restaurant;
		this.menuList = menuList;
	}
	
	
}
