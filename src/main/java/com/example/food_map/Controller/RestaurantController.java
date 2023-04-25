package com.example.food_map.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.food_map.Entity.Restaurant;
import com.example.food_map.Service1.ifs.RestaurantService;
import com.example.food_map.vo.RestaurantRequest;
import com.example.food_map.vo.RestaurantResponse;



public class RestaurantController {
	
	@Autowired
	private RestaurantService service;
	
	@PostMapping("/add_Restaurant")
	private RestaurantResponse addRestaurant(@RequestBody RestaurantRequest request) {
		return service.addRestaurant(request);
	}
	
	@PostMapping("/get_Restaurant")
	private List<Restaurant> getRestaurant(){
		return service.getRestaurant();
	}
	
	@PostMapping("/get_Restaurant_By_City_Containing")
	private List<Restaurant> getRestaurantByCity(@RequestBody RestaurantRequest request){
		return service.getRestaurantByCity(request.getCity());
	}
	

	@PostMapping("/get_Restaurant_By_Star_Less_Than_Equal_Order_By_Star_Desc")
	private List<Restaurant> getRestaurantByStarLessThanEqualOrderByStarDesc(@RequestBody RestaurantRequest request){
		return service.getRestaurantByStarLessThanEqualOrderByStarDesc(request.getStar());
	}

}
