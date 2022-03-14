package com.projects.service;

import com.projects.model.api.request.RestaurantRequest;
import com.projects.model.api.response.RestaurantResponse;

import java.util.List;

public interface RestaurantService {
  
  List<RestaurantResponse> findByCategory(String category);
  
  RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest);
  
}
