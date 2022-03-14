package com.projects.service.impl;

import com.projects.builder.UserBuilder;
import com.projects.exception.ErrorException;
import com.projects.model.api.request.UserRequest;
import com.projects.model.api.response.UserResponse;
import com.projects.model.entity.User;
import com.projects.repository.UserRepository;
import com.projects.service.RestaurantService;
import com.projects.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  
  @Autowired
  private UserRepository userRepository;
  private static final Logger logger = LogManager.getLogger(RestaurantService.class);
  
  @Override
  public List<UserResponse> findByCategory(String category) {
    List<User> userList = userRepository.findByCategory(category);
    if (userList.isEmpty()) {
      throw new ErrorException("Not found users.");
    }
    logger.info("User information was found.");
    return UserBuilder.toUserResponseList(userList);
  }
  
  @Override
  public UserResponse createUser(UserRequest userRequest) {
    return UserBuilder.toUserResponse(userRepository.save(UserBuilder.requestToUser(userRequest)));
  }
}