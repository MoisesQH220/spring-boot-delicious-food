package com.projects.model.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequest implements Serializable {
  
  private static final long serialVersionUID = -2489850791495320L;
  
  @ApiModelProperty(value = "Restaurant name", example = "Demon Sandwich", position = 1)
  private String name;
  
  @ApiModelProperty(value = "Full owner name", example = "Mariano Jose Vásquez Solano", position = 2)
  private String ownerName;
  
  @ApiModelProperty(value = "Owner cellphone", example = "987451681", position = 3)
  private String cellphone;
  
  @ApiModelProperty(value = "Restaurant category", example = "Fast Food", position = 4)
  private String category;
  
  @ApiModelProperty(value = "Geographical restaurant information", position = 5)
  private GeographicalRequest geoInfo;
  
}
