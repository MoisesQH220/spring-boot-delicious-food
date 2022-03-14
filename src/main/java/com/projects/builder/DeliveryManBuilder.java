package com.projects.builder;

import com.projects.model.api.request.DeliveryManRequest;
import com.projects.model.api.request.RestaurantRequest;
import com.projects.model.api.response.DeliveryManResponse;
import com.projects.model.api.response.RestaurantResponse;
import com.projects.model.entity.DeliveryMan;
import com.projects.model.entity.GeoInfo;
import com.projects.model.entity.Restaurant;
import com.projects.model.entity.Vehicle;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DeliveryManBuilder {
  
  public static DeliveryManResponse toDeliveryManResponse(DeliveryMan deliveryMan) {
    return DeliveryManResponse.builder()
      .name(deliveryMan.getName())
      .address(deliveryMan.getAddress())
      .cellphone(deliveryMan.getCellphone())
      .build();
  }
  
  public static DeliveryMan requestToDeliveryMan(DeliveryManRequest deliveryManRequest) {
    return DeliveryMan.builder()
      .name(deliveryManRequest.getName())
      .address(deliveryManRequest.getAddress())
      .cellphone(deliveryManRequest.getCellphone())
      .vehicle(Vehicle.builder()
        .type(Objects.nonNull(deliveryManRequest.getVehicle()) ? deliveryManRequest.getVehicle().getType() : null)
        .make(Objects.nonNull(deliveryManRequest.getVehicle()) ? deliveryManRequest.getVehicle().getMake() : null)
        .licensePlate(Objects.nonNull(deliveryManRequest.getVehicle()) ? deliveryManRequest.getVehicle().getLicensePlate() : null)
        .dateCreate(new Date())
        .build())
      .dateCreate(new Date())
      .build();
  }
}
