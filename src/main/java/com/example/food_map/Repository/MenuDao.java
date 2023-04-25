package com.example.food_map.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.food_map.Entity.Menu;




@Repository
public interface MenuDao extends JpaRepository<Menu, String>{
	boolean existsByStoreMenu(String storeMenu);

	boolean existsByStoreName(String storeName);

	Optional<Menu> findByStoreName(String storeName);




}
