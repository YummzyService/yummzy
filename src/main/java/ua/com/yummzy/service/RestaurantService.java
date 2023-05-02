package ua.com.yummzy.service;

import org.springframework.data.domain.Pageable;
import ua.com.yummzy.rest.dto.DishDTO;
import ua.com.yummzy.rest.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {

    void createRestaurant(RestaurantDTO body);

    void updateRestaurant(RestaurantDTO body, String id);

    List<RestaurantDTO> getRestaurants(Pageable pageable);

    RestaurantDTO getRestaurantById(String id);

    List<DishDTO> getDishesByRestaurantId(String id, Pageable pageable);
}
