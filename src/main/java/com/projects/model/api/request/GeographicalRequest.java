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
public class GeographicalRequest implements Serializable {
  
  private static final long serialVersionUID = -2489850791495320L;
  
  @ApiModelProperty(value = "Country", example = "Peru", position = 1)
  private String country;
  
  @ApiModelProperty(value = "City of country", example = "Lima", position = 2)
  private String city;
  
  @ApiModelProperty(value = "State of city", example = "Lima", position = 3)
  private String state;
  
  @ApiModelProperty(value = "Zip code", example = "15809", position = 4)
  private String zip_code;
  
}
