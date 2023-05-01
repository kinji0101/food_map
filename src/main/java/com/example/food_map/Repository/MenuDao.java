package com.example.food_map.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.food_map.Entity.Menu;
import com.example.food_map.Entity.RestaurantAndMenu;


@Repository
public interface MenuDao extends JpaRepository<Menu, RestaurantAndMenu>{
	
	boolean existsByStoreMenu(String storeMenu);

	boolean existsByStoreName(String storeName);

	public List<Menu> findByStoreName(String storeName);

	void deleteByStoreName(String storeName);

	List<RestaurantAndMenu> findByMenuStarGreaterThan(Integer menustaar);

}
