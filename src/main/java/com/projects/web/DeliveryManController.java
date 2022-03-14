package com.projects.web;

import com.projects.model.api.request.DeliveryManRequest;
import com.projects.model.api.response.DeliveryManResponse;
import com.projects.model.api.response.RestaurantResponse;
import com.projects.service.DeliveryManService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.projects.util.Constants.DM_TAG_DESC;
import static com.projects.util.Constants.DM_TAG_NAME;
import static com.projects.util.Constants.POST;
import static com.projects.util.Constants.POST_DELIVERY_MAN;

@RestController
@RequestMapping("api/v1.0/delivery-men")
@Api(tags = DM_TAG_NAME, description = DM_TAG_DESC)
@Validated
@Slf4j
@RequiredArgsConstructor
public class DeliveryManController {
  
  @Autowired
  private DeliveryManService deliveryManService;
  
  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = POST_DELIVERY_MAN, response = RestaurantResponse.class, httpMethod = POST)
  public DeliveryManResponse postRestaurant(@RequestBody DeliveryManRequest restaurantRequest) {
    return deliveryManService.createDeliveryMan(restaurantRequest);
  }
  
}
