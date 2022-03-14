package com.projects.builder;

import com.projects.model.api.response.RestaurantResponse;
import com.projects.model.entity.Restaurant;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class RestaurantBuilder {
  
  public static RestaurantResponse toRestaurantResponse(Restaurant restaurant) {
    return RestaurantResponse.builder()
      .name(restaurant.getName())
      .ownerName(restaurant.getOwnerName())
      .cellphone(restaurant.getCellphone())
      .category(restaurant.getCategory())
      .build();
  }
}
