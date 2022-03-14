package com.projects.model.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequest implements Serializable {
  
  private static final long serialVersionUID = -2489850791495320L;
  
  @ApiModelProperty(value = "Vehicle type", example = "Car", position = 1)
  private String type;
  
  @ApiModelProperty(value = "Vehicle make", example = "Toyota", position = 2)
  private String make;
  
  @ApiModelProperty(value = "Vehicle license plate", example = "APC105", position = 3)
  private String licensePlate;
  
}
