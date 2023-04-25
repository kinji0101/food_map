package com.example.food_map.Service1.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.food_map.Entity.Menu;
import com.example.food_map.Entity.Restaurant;
import com.example.food_map.Repository.MenuDao;
import com.example.food_map.Repository.RestaurantDao;
import com.example.food_map.Service1.ifs.MenuService;
import com.example.food_map.Service1.ifs.RestaurantService;
import com.example.food_map.vo.MenuRequest;
import com.example.food_map.vo.MenuResponse;
import com.example.food_map.vo.RestaurantRequest;
import com.example.food_map.vo.RestaurantResponse;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	
	@Autowired
	private MenuDao menuDao;
	

	@Override
	public RestaurantResponse addRestaurant(RestaurantRequest request) {
		List<Restaurant> errorInfoList = new ArrayList<>();
		List<Restaurant> infoList = request.getRestaurantList();
		for (Restaurant item : infoList) {
			if(!StringUtils.hasText(item.getId()) || !StringUtils.hasText(item.getCity())) {
				return new RestaurantResponse("Add Restaurant Info error");
			}
			if(restaurantDao.existsById(item.getId())) {
				return new RestaurantResponse("店家已存在");
			}
			if(1 > request.getStar() || 5 < request.getStar()) {
				return new RestaurantResponse("Add Restaurant Info error");				
			}
			
		}	
		restaurantDao.saveAll(infoList);
		return new RestaurantResponse(infoList, "Add Restaurant Info Successful");
	}
	
	@Override
	public MenuResponse addMenu(MenuRequest request) {
		List<Menu> errorInfoList = new ArrayList<>();
		List<Menu> infoList = request.getMenuList();
		for (Menu item : infoList) {
			if (!StringUtils.hasText(item.getStoreMenu()) || !StringUtils.hasText(item.getStoreName())) {
				return new MenuResponse("Add Menu Info error");
			}
			if (menuDao.existsByStoreMenu(item.getStoreMenu())) {
				errorInfoList.add(item);
			}
			if (menuDao.existsByStoreName(item.getStoreName())) {
				errorInfoList.add(item);
			}
			if (1 > request.getMenustar() || 5 < request.getMenustar()) {
				return new MenuResponse("Add Menu Info error");
			}

		}
		if (!errorInfoList.isEmpty()) {
			return new MenuResponse("店家已存在");
		}
		menuDao.saveAll(infoList);
		return new MenuResponse(infoList, "Add Menu Info Successful");
	}


	@Override
	public List<Restaurant> getRestaurant() {
		return restaurantDao.findAll();		
	}

	@Override
	public RestaurantResponse getRestaurantById(String id) {
		if(!StringUtils.hasText(id)) {
			return new RestaurantResponse("id 不得為空");
	}
		Optional<Restaurant> op = restaurantDao.findById(id);
		if(op.isPresent()) {
			return new RestaurantResponse(op.get());
		}
		return new RestaurantResponse("查無資料");
	}

	
	@Override
	public List<Restaurant> getRestaurantByCity(String city) {
		return restaurantDao.findByCity(city);
	}

	
	@Override
	public List<Restaurant> getRestaurantByStarLessThanEqualOrderByStarDesc(int star) {
		return restaurantDao.findContainingByStarLessThanEqualOrderByStarDesc(star);
	}

	
	@Override
	public RestaurantResponse updateRestaurant(RestaurantRequest RestaurantupdateRequest) {
		String reqName = RestaurantupdateRequest.getId();
		String reqCity = RestaurantupdateRequest.getCity();
		String reqNewCity = RestaurantupdateRequest.getNewCity();

		if (!StringUtils.hasText(reqName) || !StringUtils.hasText(reqCity) || !StringUtils.hasText(reqNewCity)) {
			return new RestaurantResponse("修改內容不能為空");
		}

		Optional<Restaurant> op = restaurantDao.findById(reqName);
		if (!op.isPresent()) {
			return new RestaurantResponse(reqName, "沒有此店家");
		}
		Restaurant restaurant = op.get();
		if (!reqCity.equals(restaurant.getCity())) {
			return new RestaurantResponse(reqCity, "該店家不在此地區");
		}
		restaurant.setCity(reqNewCity);
		restaurantDao.save(restaurant);
		return new RestaurantResponse(reqName, "修改城市成功");
	}
	
	@Override
	public RestaurantResponse UpdateRestaurantStar(RestaurantRequest request) {
		if (!StringUtils.hasText(request.getId()) || !StringUtils.hasText(request.getCity())) {
			return new RestaurantResponse("資料不能為空");
		}
		Optional<Restaurant> op = restaurantDao.findById(request.getId());
		if (!op.isPresent()) {
			return new RestaurantResponse(request.getId(), "沒有此店家");
		}
		Restaurant eatMap = op.get();
		if (!request.getCity().equals(eatMap.getCity())) {
			return new RestaurantResponse(request.getId(), "該店家不在此地區");
		}
		var list = restaurantDao.findAll();
		int sum = 0;
		int star = 0;
		for (int limit = 0; limit <= 2; limit++) {
			Restaurant item = list.get(limit);
			sum += item.getStar();
			if (limit == list.size() - 1) {
				star = sum / list.size();
				break;
			}
		}
		eatMap.setStar(star);
		restaurantDao.save(eatMap);
		return new RestaurantResponse(request.getId(), "修改評分成功");

	}
	

}
