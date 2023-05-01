package com.example.food_map.Service1.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.food_map.Entity.Menu;
import com.example.food_map.Repository.MenuDao;
import com.example.food_map.Service1.ifs.MenuService;
import com.example.food_map.vo.MenuRequest;
import com.example.food_map.vo.MenuResponse;

@Service
public class MenuServicceImpl implements MenuService{
	
	@Autowired
	private MenuDao menuDao;
	

	@Override
	public MenuResponse addMenu(MenuRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> getMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MenuResponse getMenuBystoreName(String storeName) {
		// TODO Auto-generated method stub
		return null;
	}

}
