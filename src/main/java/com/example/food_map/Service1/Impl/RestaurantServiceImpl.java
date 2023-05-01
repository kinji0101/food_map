package com.example.food_map.Service1.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.food_map.Entity.Menu;
import com.example.food_map.Entity.Restaurant;
import com.example.food_map.Entity.RestaurantAndMenu;
import com.example.food_map.Entity.responseRestAndMenu;
import com.example.food_map.Repository.MenuDao;
import com.example.food_map.Repository.RestaurantDao;
import com.example.food_map.Service1.ifs.RestaurantService;
import com.example.food_map.vo.MenuRequest;
import com.example.food_map.vo.MenuResponse;
import com.example.food_map.vo.RestaurantAndMenuResponse;
import com.example.food_map.vo.RestaurantRequest;
import com.example.food_map.vo.RestaurantResponse;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDao restaurantDao;

	@Autowired
	private MenuDao menuDao;

	@Override
	public RestaurantResponse addRestaurant(RestaurantRequest request) {
		List<Restaurant> errorInfoList = new ArrayList<>();
		List<Restaurant> infoList = request.getRestaurantList();
		for (Restaurant item : infoList) {
			if (!StringUtils.hasText(item.getId()) || !StringUtils.hasText(item.getCity())) {
				return new RestaurantResponse("Add Restaurant Info error");
			}
			if (restaurantDao.existsById(item.getId())) {
				errorInfoList.add(item);
			}
		}
		if (!errorInfoList.isEmpty()) {
			return new RestaurantResponse("���a�w�s�b");
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

		}
		if (!errorInfoList.isEmpty()) {
			return new MenuResponse("���a�w�s�b");
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
		if (!StringUtils.hasText(id)) {
			return new RestaurantResponse("id ���o����");
		}
		Optional<Restaurant> op = restaurantDao.findById(id);
		if (op.isPresent()) {
			return new RestaurantResponse(op.get());
		}
		return new RestaurantResponse("�d�L���");
	}

	@Override
	public List<Restaurant> getRestaurantByCity(String city) {
		return restaurantDao.findByCity(city);
	}

	@Override
	public List<Restaurant> getRestaurantByStarGreaterThanEqualOrderByStarAsc(int star) {
		return restaurantDao.findContainingByStarLessThanEqualOrderByStarDesc(star);
	}

	@Transactional
	@Override
	public RestaurantResponse updateRestaurant(RestaurantRequest RestaurantupdateRequest) {
		String reqName = RestaurantupdateRequest.getId();
		String reqCity = RestaurantupdateRequest.getCity();
		String reqNewCity = RestaurantupdateRequest.getNewCity();

		if (!StringUtils.hasText(reqName) || !StringUtils.hasText(reqCity) || !StringUtils.hasText(reqNewCity)) {
			return new RestaurantResponse("�ק鷺�e���ର��");
		}

		Optional<Restaurant> op = restaurantDao.findById(reqName);
		if (!op.isPresent()) {
			return new RestaurantResponse(reqName, "�S�������a");
		}
		Restaurant restaurant = op.get();
		if (!reqCity.equals(restaurant.getCity())) {
			return new RestaurantResponse(reqCity, "�ө��a���b���a��");
		}
		restaurant.setCity(reqNewCity);
		restaurantDao.save(restaurant);
		return new RestaurantResponse(reqName, "�ק﫰�����\");
	}

	@Transactional
	@Override
	public RestaurantAndMenuResponse updateRestaurantStar(RestaurantRequest request) {
		List<Restaurant> infoList = request.getRestaurantList();
		for (Restaurant item : infoList) {
			if (!StringUtils.hasText(item.getId()) || !StringUtils.hasText(item.getCity())) {
				return new RestaurantAndMenuResponse("Add Restaurant Info error");
			}
			Optional<Restaurant> optionalRestaurant = restaurantDao.findById(item.getId());
			if (!optionalRestaurant.isPresent()) {
				return new RestaurantAndMenuResponse(item.getId(), "���a���s�b");
			}
			Restaurant restaurant = optionalRestaurant.get();
			if (!restaurant.getCity().equals(item.getCity())) {
				return new RestaurantAndMenuResponse(item.getId(), "�ө��a���b���a��");
			}
			List<Menu> StarList = menuDao.findByStoreName(item.getId());
			double totalStar = 0;
			for (Menu menu : StarList) {
				totalStar += menu.getMenuStar();
			}
			double averageStar = totalStar / StarList.size();
			restaurant.setStar(averageStar);
			restaurantDao.save(restaurant);

			return new RestaurantAndMenuResponse(infoList, "��s���a�������\");
		}
		return null;
	}

	@Transactional
	@Override
	public RestaurantAndMenuResponse deleteRestaurant(RestaurantRequest request) {
		List<Restaurant> infoList = request.getRestaurantList();
		for (Restaurant item : infoList) {
			if (!StringUtils.hasText(item.getId()) || !StringUtils.hasText(item.getCity())) {
				return new RestaurantAndMenuResponse("Add Restaurant Info error");
			}
			Optional<Restaurant> optionalRestaurant = restaurantDao.findById(item.getId());
			if (!optionalRestaurant.isPresent()) {
				return new RestaurantAndMenuResponse(item.getId(), "���a���s�b");
			}
			Restaurant restaurant = optionalRestaurant.get();
			if (!restaurant.getCity().equals(item.getCity())) {
				return new RestaurantAndMenuResponse(item.getId(), "�ө��a���b���a��");
			}

			if (menuDao.existsByStoreName(item.getId())) {
				menuDao.deleteByStoreName(item.getId());
				restaurantDao.deleteById(item.getId());
			}
		}
		return new RestaurantAndMenuResponse(infoList, "�R�����a���\");

	}

	
	@Transactional
	@Override
	public RestaurantResponse getMapByCity(RestaurantRequest request) {
		String reqCity = request.getCity();
		int reqLim = request.getLimit();
		if(!StringUtils.hasText(reqCity)) {
			return new RestaurantResponse("�w�j�M�����нT���J");
		}
		List<Restaurant> getRestList = restaurantDao.findByCity(reqCity); // �w�j�M�������Ҧ��\�U
		List<Restaurant> limRestList = new ArrayList<>(); // �w�j�M�������ۭq�\�U�q
		List<responseRestAndMenu> reRAML = new ArrayList<>(); // �n��X���\�U+��檺�C��
		if(reqLim == 0) {
			for(Restaurant getRest : getRestList) {
				List<Menu> limRestMenuList = menuDao.findByStoreName(getRest.getId()); 
				responseRestAndMenu RAM = new responseRestAndMenu(getRest , limRestMenuList);
				reRAML.add(RAM);
			}
			return new RestaurantResponse("�d�ߦ��\", reRAML);
		}	
		if(reqLim > getRestList.size()) {
			return new RestaurantResponse("�w�j�M���\�U�Ƥj���`�\�U��");
		}
		for(int i = 0 ; i < reqLim ; i++) {
			limRestList.add(getRestList.get(i));
		}
		for(Restaurant limRest : limRestList) {
			List<Menu> limRestMenuList = menuDao.findByStoreName(limRest.getId());
			responseRestAndMenu RAM = new responseRestAndMenu(limRest , limRestMenuList);
			reRAML.add(RAM);
		}
		return new RestaurantResponse("�d�ߦ��\", reRAML);
	}
	
	@Transactional
	@Override
	public RestaurantResponse getMapByStarGreaterThanEqual(RestaurantRequest request) {
		Double reqStar = Double.valueOf(request.getStar());
		if(Objects.isNull(reqStar)) {
			return new RestaurantResponse("�w�j�M�����нT���J");
		}
		List<Restaurant> getRestList = restaurantDao.findByStarGreaterThanEqual(reqStar); // �w�j�M�������Ҧ��\�U
		List<responseRestAndMenu> reRAML = new ArrayList<>(); // �n��X���\�U+��檺�C��
			for(Restaurant getRest : getRestList) {
				List<Menu> limRestMenuList = menuDao.findByStoreName(getRest.getId()); 
				responseRestAndMenu RAM = new responseRestAndMenu(getRest , limRestMenuList);
				reRAML.add(RAM);
			}
			return new RestaurantResponse("�d�ߦ��\", reRAML);			
	}
	
	

}