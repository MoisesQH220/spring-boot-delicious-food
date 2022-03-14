package com.projects.service;

import com.projects.model.api.request.DeliveryManRequest;
import com.projects.model.api.request.RestaurantRequest;
import com.projects.model.api.response.DeliveryManResponse;
import com.projects.model.api.response.RestaurantResponse;

import java.util.List;

public interface DeliveryManService {
  
  DeliveryManResponse createDeliveryMan(DeliveryManRequest deliveryManRequest);
  
}
