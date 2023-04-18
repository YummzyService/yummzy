package ua.com.yummzy.service;

import org.springframework.data.domain.Pageable;
import ua.com.yummzy.dto.DishDto;
import ua.com.yummzy.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    List<RestaurantDto> getAllRestaurants(Pageable pageable);

    RestaurantDto getRestaurantById(String id);

    List<DishDto> getDishesByRestaurantId(String id, Pageable pageable);
}
