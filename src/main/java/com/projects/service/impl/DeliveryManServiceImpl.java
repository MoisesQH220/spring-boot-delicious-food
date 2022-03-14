package com.projects.service.impl;

import com.projects.builder.DeliveryManBuilder;
import com.projects.builder.RestaurantBuilder;
import com.projects.model.api.request.DeliveryManRequest;
import com.projects.model.api.response.DeliveryManResponse;
import com.projects.repository.DeliveryManRepository;
import com.projects.service.DeliveryManService;
import com.projects.service.RestaurantService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryManServiceImpl implements DeliveryManService {
  
  @Autowired
  private DeliveryManRepository deliveryManRepository;
  private static final Logger logger = LogManager.getLogger(RestaurantService.class);
  
  
  @Override
  public DeliveryManResponse createDeliveryMan(DeliveryManRequest deliveryManRequest) {
    return DeliveryManBuilder.toDeliveryManResponse(deliveryManRepository.save(DeliveryManBuilder.requestToDeliveryMan(deliveryManRequest)));
  }
}