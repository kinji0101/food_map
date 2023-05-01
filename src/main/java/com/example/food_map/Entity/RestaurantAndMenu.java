package com.example.food_map.Entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RestaurantAndMenu implements Serializable{
	
	private String storeName;
	
	private String storeMenu;
	
	private Integer price;
	
	private Integer menuStar;
		
	
	public  RestaurantAndMenu() {
		
	}

	public RestaurantAndMenu(String storeName, String storeMenu) {
		this.storeName = storeName;
		this.storeMenu = storeMenu;
	}

	public RestaurantAndMenu(String storeName) {
		super();
		this.storeName = storeName;
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

	public Integer getMenuStar() {
		return menuStar;
	}

	public void setMenuStar(Integer menuStar) {
		this.menuStar = menuStar;
	}



	
	


	
	

}
