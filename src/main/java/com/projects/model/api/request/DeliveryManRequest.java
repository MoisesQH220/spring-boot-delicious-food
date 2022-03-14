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
public class DeliveryManRequest implements Serializable {
  
  private static final long serialVersionUID = -2489850791495320L;
  
  @ApiModelProperty(value = "Delivery man name", example = "Mariano Jose Vásquez Solano", position = 1)
  private String name;
  
  @ApiModelProperty(value = "Delivery man address", example = "Av. Jose Pardo", position = 2)
  private String address;
  
  @ApiModelProperty(value = "Delivery man cellphone", example = "987451681", position = 3)
  private String cellphone;
  
  @ApiModelProperty(value = "Delivery man vehicle", position = 4)
  private VehicleRequest vehicle;
  
}
