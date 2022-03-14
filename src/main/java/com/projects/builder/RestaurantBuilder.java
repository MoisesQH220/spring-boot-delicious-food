package com.projects.builder;

import com.projects.model.api.request.RestaurantRequest;
import com.projects.model.api.response.RestaurantResponse;
import com.projects.model.entity.GeoInfo;
import com.projects.model.entity.Restaurant;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class RestaurantBuilder {
  
  public static List<RestaurantResponse> toRestaurantResponseList(List<Restaurant> restaurantList) {
    return restaurantList.stream()
      .map(RestaurantBuilder::toRestaurantResponse)
      .collect(Collectors.toList());
  }
  
  public static RestaurantResponse toRestaurantResponse(Restaurant restaurant) {
    return RestaurantResponse.builder()
      .name(restaurant.getName())
      .ownerName(restaurant.getOwnerName())
      .cellphone(restaurant.getCellphone())
      .category(restaurant.getCategory())
      .build();
  }
  
  public static Restaurant requestToRestaurant(RestaurantRequest restaurantRequest) {
    return Restaurant.builder()
      .name(restaurantRequest.getName())
      .ownerName(restaurantRequest.getOwnerName())
      .cellphone(restaurantRequest.getCellphone())
      .category(restaurantRequest.getCategory())
      .geoInfo(GeoInfo.builder()
        .country(Objects.nonNull(restaurantRequest.getGeoInfo()) ? restaurantRequest.getGeoInfo().getCountry() : null)
        .city(Objects.nonNull(restaurantRequest.getGeoInfo()) ? restaurantRequest.getGeoInfo().getCity() : null)
        .state(Objects.nonNull(restaurantRequest.getGeoInfo()) ? restaurantRequest.getGeoInfo().getState() : null)
        .zipCode(Objects.nonNull(restaurantRequest.getGeoInfo()) ? restaurantRequest.getGeoInfo().getZipCode() : null)
        .build())
      .build();
  }
}
