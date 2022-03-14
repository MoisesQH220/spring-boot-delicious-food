package com.projects.model.api.response;

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
public class UserResponse implements Serializable {
  
  private static final long serialVersionUID = -2489850791495320L;
  
  @ApiModelProperty(value = "Full user name", example = "Sofia Alexandra Herrera Vásquez", position = 1)
  private String name;
  
  @ApiModelProperty(value = "User address", example = "Av. Javier Prado 268", position = 2)
  private String address;
  
  @ApiModelProperty(value = "Preferred user category", example = "Fast Food", position = 3)
  private String category;
  
}
