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
  
  @ApiModelProperty(value = "Full owner name", example = "Mariano Jose Vásquez Solano", position = 1)
  private String ownerName;
  
  @ApiModelProperty(value = "Owner cellphone", example = "987451681", position = 2)
  private String cellphone;
  
  @ApiModelProperty(value = "Restaurant category", example = "Fast Food", position = 3)
  private String category;
  
  @ApiModelProperty(value = "Geographical restaurant information", position = 4)
  private GeographicalRequest geographicalRequest;
  
}
