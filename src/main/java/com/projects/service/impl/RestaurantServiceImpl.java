package com.projects.service.impl;

import com.projects.builder.RestaurantBuilder;
import com.projects.exception.ErrorException;
import com.projects.model.api.request.RestaurantRequest;
import com.projects.model.api.response.RestaurantResponse;
import com.projects.model.entity.Restaurant;
import com.projects.repository.RestaurantRepository;
import com.projects.service.RestaurantService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
  
  @Autowired
  private RestaurantRepository restaurantRepository;
  private static final Logger logger = LogManager.getLogger(RestaurantService.class);
  
  @Override
  public List<RestaurantResponse> findByCategory(String category) {
    List<Restaurant> restaurantList = restaurantRepository.findByCategory(category);
    if (restaurantList.isEmpty()) {
      throw new ErrorException("Not found restaurants.");
    }
    logger.info("Restaurant information was found.");
    return RestaurantBuilder.toRestaurantResponseList(restaurantList);
  }
  
  @Override
  public RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest) {
    return RestaurantBuilder.toRestaurantResponse(restaurantRepository.save(RestaurantBuilder.requestToRestaurant(restaurantRequest)));
  }
}