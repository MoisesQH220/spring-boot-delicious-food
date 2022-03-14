package com.projects.web;

import com.projects.model.api.request.UserRequest;
import com.projects.model.api.response.UserResponse;
import com.projects.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.projects.util.Constants.GET;
import static com.projects.util.Constants.GET_USER_CATEGORY;
import static com.projects.util.Constants.POST;
import static com.projects.util.Constants.POST_USER;
import static com.projects.util.Constants.US_TAG_DESC;
import static com.projects.util.Constants.US_TAG_NAME;

@RestController
@RequestMapping("api/v1.0/users")
@Api(tags = US_TAG_NAME, description = US_TAG_DESC)
@Validated
@Slf4j
@RequiredArgsConstructor
public class UserController {
  
  @Autowired
  private UserService userService;
  
  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = POST_USER, response = UserResponse.class, httpMethod = POST)
  public UserResponse postRestaurant(@RequestBody UserRequest userRequest) {
    return userService.createUser(userRequest);
  }
  
  @GetMapping(value = "/{category}",
    produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = GET_USER_CATEGORY, response = UserResponse.class, httpMethod = GET)
  public List<UserResponse> getRestaurantByCategory(@PathVariable(value = "category") String category) {
    return userService.findByCategory(category);
  }
  
}
