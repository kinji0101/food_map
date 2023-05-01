package com.example.food_map.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.food_map.Entity.Menu;
import com.example.food_map.Entity.Restaurant;
import com.example.food_map.Entity.RestaurantAndMenu;


@Repository
public interface RestaurantDao extends JpaRepository <Restaurant, String>{
	
	List<Restaurant> findByCity(String city);

	List<Restaurant> findContainingByStarLessThanEqualOrderByStarDesc(int star);

	List<RestaurantAndMenu> findByStarGreaterThan(Integer star);

	List<Restaurant> findByStarGreaterThanEqual(Double Star);

	


//	List<Restaurant> findByCity(String city);
//
//	List<Restaurant> findContainingByStarLessThanEqualOrderByStarDesc(int star);
//	
//	List<Restaurant> findByPointGreaterThanEqualOrderByPointDesc(Integer point);
//


}
