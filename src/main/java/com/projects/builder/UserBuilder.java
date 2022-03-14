package com.projects.builder;

import com.projects.model.api.response.RestaurantResponse;
import com.projects.model.api.response.UserResponse;
import com.projects.model.entity.Restaurant;
import com.projects.model.entity.User;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserBuilder {
  
  public static UserResponse toRestaurantResponse(User user) {
    return UserResponse.builder()
      .name(user.getName())
      .address(user.getAddress())
      .category(user.getCategory())
      .build();
  }
}
