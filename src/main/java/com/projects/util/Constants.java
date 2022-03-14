package com.projects.util;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class Constants {
  public static final String RS_TAG_NAME = "Restaurant";
  public static final String RS_TAG_DESC = "Manage the information of restaurants.";
  public static final String US_TAG_NAME = "User";
  public static final String US_TAG_DESC = "Manage the information of users.";
  public static final String DM_TAG_NAME = "Delivery man";
  public static final String DM_TAG_DESC = "Manage the information of delivery men.";
  public static final String GET = "GET";
  public static final String POST = "POST";
  
  public static final String POST_RESTAURANT = "Functionality that allows to record information about a restaurant.";
  public static final String GET_RESTAURANT_CATEGORY = "Functionality that allows you to get the list of restaurants by category.";
  
  public static final String POST_USER = "Functionality that allows to record information about a user.";
  public static final String GET_USER_CATEGORY = "Functionality that allows you to get the list of users by category.";
  
  public static final String POST_DELIVERY_MAN = "Functionality that allows to record information about a restaurant.";
  
}
