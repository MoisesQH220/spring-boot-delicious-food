package com.projects.service;

import com.projects.model.api.request.UserRequest;
import com.projects.model.api.response.UserResponse;

import java.util.List;

public interface UserService {
  
  List<UserResponse> findByCategory(String category);
  
  UserResponse createUser(UserRequest userRequest);
  
}
