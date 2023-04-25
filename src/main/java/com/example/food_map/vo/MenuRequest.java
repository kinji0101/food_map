package com.example.food_map.vo;

import java.util.List;

import com.example.food_map.Entity.Menu;
import com.fasterxml.jackson.annotation.JsonProperty;



public class MenuRequest {
	
	@JsonProperty("menu")
	private Menu menu;
	
	@JsonProperty("menu_list")
	private List<Menu> menuList;
	
	private String storeName;
	
	private String storeMenu;
	
	private int menustar;
	
	private int price;
	
	public MenuRequest() {
		
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
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

	public int getMenustar() {
		return menustar;
	}

	public void setMenustar(int menustar) {
		this.menustar = menustar;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

}
