package com.example.food_map.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



@Entity
@Table(name = "menu")
@IdClass(value = RestaurantAndMenu.class)
public class Menu {
	
	@Id
	@Column(name = "store_name")
	private String storeName;
	
	@Id
	@Column(name = "store_menu")
	private String storeMenu;
	
	@Column(name = "price")
	private Integer price;
	
	
	@Column(name = "menu_star")
	private Integer menustar;


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
