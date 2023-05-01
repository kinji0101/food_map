package com.example.food_map.Service1.ifs;

import java.util.List;

import com.example.food_map.Entity.Restaurant;
import com.example.food_map.Entity.RestaurantAndMenu;
import com.example.food_map.vo.MenuRequest;
import com.example.food_map.vo.MenuResponse;
import com.example.food_map.vo.RestaurantAndMenuResponse;
import com.example.food_map.vo.RestaurantRequest;
import com.example.food_map.vo.RestaurantResponse;



public interface RestaurantService {
	
	public RestaurantResponse addRestaurant(RestaurantRequest request);
	
	public List<Restaurant> getRestaurant();
	 
	public RestaurantResponse getRestaurantById(String id);		

	public List<Restaurant> getRestaurantByCity(String city);

	public RestaurantResponse updateRestaurant(RestaurantRequest RestaurantupdateRequest);

	public MenuResponse addMenu(MenuRequest request);

	public List<Restaurant> getRestaurantByStarGreaterThanEqualOrderByStarAsc(int star);

	public RestaurantAndMenuResponse updateRestaurantStar(RestaurantRequest request);

	public RestaurantAndMenuResponse deleteRestaurant(RestaurantRequest request);

//	List<RestaurantAndMenuResponse> getMapByCity(String City);

	public RestaurantResponse getMapByCity(RestaurantRequest request);

	RestaurantResponse getMapByStarGreaterThanEqual(RestaurantRequest request);

	

	

	




}
