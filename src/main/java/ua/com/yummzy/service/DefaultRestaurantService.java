package ua.com.yummzy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.yummzy.common.exception.NotFoundException;
import ua.com.yummzy.common.mapper.DishMapper;
import ua.com.yummzy.common.mapper.RestaurantsMapper;
import ua.com.yummzy.common.rest.DishRestResponse;
import ua.com.yummzy.common.rest.RestaurantRestResponse;
import ua.com.yummzy.repository.DishRepository;
import ua.com.yummzy.repository.RestaurantRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultRestaurantService implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final DishRepository dishRepository;
    private final RestaurantsMapper restaurantsMapper;
    private final DishMapper dishMapper;

    @Override
    public List<RestaurantRestResponse> getAllRestaurants(Pageable pageable) {
        return restaurantRepository.findAll(pageable).getContent().stream()
                .map(restaurantsMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantRestResponse getRestaurantById(String id) {
        var restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("RestaurantDocument with id " + id + " not found!"));
        return restaurantsMapper.toResponse(restaurant);
    }

    @Override
    public List<DishRestResponse> getDishesByRestaurantId(String id, Pageable pageable) {
        return dishRepository.findAllByRestaurantId(id, pageable).stream()
                .map(dishMapper::toResponse)
                .collect(Collectors.toList());
    }
}
