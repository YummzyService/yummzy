package ua.com.yummzy.service;

import org.springframework.data.domain.Pageable;
import ua.com.yummzy.common.rest.DishRestResponse;
import ua.com.yummzy.common.rest.RestaurantRestResponse;

import java.util.List;

public interface RestaurantService {
    List<RestaurantRestResponse> getAllRestaurants(Pageable pageable);

    RestaurantRestResponse getRestaurantById(String id);

    List<DishRestResponse> getDishesByRestaurantId(String id, Pageable pageable);
}
