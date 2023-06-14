package ua.com.yummzy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {
    public static final String API_VERSION = "/api/v1";
    public static final String RESTAURANT_ROUTE = API_VERSION + "/restaurants";
    public static final String DISH_ROUTE = API_VERSION + "/dishes";
}
