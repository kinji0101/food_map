package com.example.food_map.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.food_map.Entity.Restaurant;
import com.example.food_map.Entity.RestaurantAndMenu;
import com.example.food_map.Service1.ifs.RestaurantService;
import com.example.food_map.vo.RestaurantAndMenuResponse;
import com.example.food_map.vo.RestaurantRequest;
import com.example.food_map.vo.RestaurantResponse;


@CrossOrigin
@RestController
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
	

	@PostMapping("/get_Restaurant_By_Star_Greater_Than_Equal_Order_By_Star_Asc")
	private List<Restaurant> getRestaurantByStarGreaterThanEqualOrderByStarAsc(@RequestBody RestaurantRequest request){
		return service.getRestaurantByStarGreaterThanEqualOrderByStarAsc(request.getStar());
	}
	
	@PostMapping("get_update_Restaurant_Star")
	private RestaurantAndMenuResponse updateRestaurantStar(@RequestBody RestaurantRequest request) {
		return service.updateRestaurantStar(request);
	}
	
	@PostMapping("delete_Restaurant")
	private RestaurantAndMenuResponse deleteRestaurant(@RequestBody RestaurantRequest request) {
		return service.deleteRestaurant(request);
	}
	
	@PostMapping("/get_Map_By_City")
	public RestaurantResponse getMapByCity(@RequestBody RestaurantRequest request) {
	    return service.getMapByCity(request);
	}
	
	@PostMapping("/get_Map_By_Star_Greater_Than_Equal")
	public RestaurantResponse getMapByStarGreaterThanEqual(@RequestBody RestaurantRequest request) {
	    return service.getMapByStarGreaterThanEqual(request);
	}

}
