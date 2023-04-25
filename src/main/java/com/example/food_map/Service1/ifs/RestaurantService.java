package com.example.food_map.Service1.ifs;

import java.util.List;

import com.example.food_map.Entity.Restaurant;
import com.example.food_map.vo.MenuRequest;
import com.example.food_map.vo.MenuResponse;
import com.example.food_map.vo.RestaurantRequest;
import com.example.food_map.vo.RestaurantResponse;



public interface RestaurantService {
	
	public RestaurantResponse addRestaurant(RestaurantRequest request);
	
	public List<Restaurant> getRestaurant();
	 
	public RestaurantResponse getRestaurantById(String id);	
	
	public List<Restaurant> getRestaurantByStarLessThanEqualOrderByStarDesc(int star);

	public List<Restaurant> getRestaurantByCity(String city);

	public RestaurantResponse updateRestaurant(RestaurantRequest RestaurantupdateRequest);

	public RestaurantResponse UpdateRestaurantStar(RestaurantRequest request);

	public MenuResponse addMenu(MenuRequest request);


}
