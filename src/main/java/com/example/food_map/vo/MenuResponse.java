package com.example.food_map.vo;

import java.util.List;

import com.example.food_map.Entity.Menu;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuResponse {
	
	@JsonProperty("menu")
	private Menu menu;
	
	@JsonProperty("menu_list")
	private List<Menu> menuList;
	
	private String message;
	
	public MenuResponse() {
		
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MenuResponse(Menu menu, List<Menu> menuList, String message) {
		super();
		this.menu = menu;
		this.menuList = menuList;
		this.message = message;
	}

	public MenuResponse(Menu menu, String message) {
		super();
		this.menu = menu;
		this.message = message;
	}

	public MenuResponse(List<Menu> menuList, String message) {
		super();
		this.menuList = menuList;
		this.message = message;
	}

	public MenuResponse(String message) {
		super();
		this.message = message;
	}

	public MenuResponse(Menu menu) {
		super();
		this.menu = menu;
	}
	
	



}
