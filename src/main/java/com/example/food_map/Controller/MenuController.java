package com.example.food_map.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.food_map.Entity.Menu;
import com.example.food_map.Service1.ifs.MenuService;
import com.example.food_map.vo.MenuRequest;
import com.example.food_map.vo.MenuResponse;

@RestController
public class MenuController {
	
	@Autowired
	private MenuService service;
	
	@PostMapping("/add_Menu")
	private MenuResponse addMenu(@RequestBody MenuRequest request) {
		return service.addMenu(request);
	}
	
	@PostMapping("/get_Menu")
	private List<Menu> getMenu(){
		return service.getMenu();
	}

}
