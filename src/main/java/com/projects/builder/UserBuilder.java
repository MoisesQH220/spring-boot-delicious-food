package com.projects.builder;

import com.projects.model.api.request.UserRequest;
import com.projects.model.api.response.UserResponse;
import com.projects.model.entity.GeoInfo;
import com.projects.model.entity.User;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserBuilder {
  
  public static List<UserResponse> toUserResponseList(List<User> restaurantList) {
    return restaurantList.stream()
      .map(UserBuilder::toUserResponse)
      .collect(Collectors.toList());
  }
  
  public static UserResponse toUserResponse(User user) {
    return UserResponse.builder()
      .name(user.getName())
      .address(user.getAddress())
      .category(user.getCategory())
      .build();
  }
  
  public static User requestToUser(UserRequest userRequest) {
    return User.builder()
      .name(userRequest.getName())
      .address(userRequest.getAddress())
      .category(userRequest.getCategory())
      .geoInfo(GeoInfo.builder()
        .country(Objects.nonNull(userRequest.getGeoInfo()) ? userRequest.getGeoInfo().getCountry() : null)
        .city(Objects.nonNull(userRequest.getGeoInfo()) ? userRequest.getGeoInfo().getCity() : null)
        .state(Objects.nonNull(userRequest.getGeoInfo()) ? userRequest.getGeoInfo().getState() : null)
        .zipCode(Objects.nonNull(userRequest.getGeoInfo()) ? userRequest.getGeoInfo().getZipCode() : null)
        .build())
      .build();
  }
}
