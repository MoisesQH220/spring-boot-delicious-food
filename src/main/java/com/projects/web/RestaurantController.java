package com.projects.web;

import com.projects.model.api.response.RestaurantResponse;
import com.projects.service.RestaurantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.projects.util.Constants.GET;
import static com.projects.util.Constants.GET_CLIENT_DESC;
import static com.projects.util.Constants.MS_TAG_DESC;
import static com.projects.util.Constants.MS_TAG_NAME;

@RestController
@RequestMapping("api/v1.0")
@Api(tags = MS_TAG_NAME, description = MS_TAG_DESC)
@Validated
@Slf4j
@RequiredArgsConstructor
public class RestaurantController {
  
  private final RestaurantService restaurantService;
  
  @GetMapping(value = "/restaurants/{category}",
    produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = GET_CLIENT_DESC, response = RestaurantResponse.class, httpMethod = GET)
  public RestaurantResponse getRestaurantByCategory(@PathVariable(value = "category") String category) {
    return restaurantService.findByCategory(category);
  }
  
}
