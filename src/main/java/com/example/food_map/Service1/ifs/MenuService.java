package com.example.food_map.Service1.ifs;

import java.util.List;

import com.example.food_map.Entity.Menu;
import com.example.food_map.vo.MenuRequest;
import com.example.food_map.vo.MenuResponse;

public interface MenuService {

	public MenuResponse addMenu(MenuRequest request);

	public List<Menu> getMenu();

	public MenuResponse getMenuBystoreName(String storeName);

}
