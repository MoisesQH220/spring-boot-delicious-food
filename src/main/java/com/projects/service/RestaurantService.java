package com.projects.service;

import com.projects.model.api.response.RestaurantResponse;

public interface RestaurantService {
  
  RestaurantResponse findByCategory(String category);
  
}
