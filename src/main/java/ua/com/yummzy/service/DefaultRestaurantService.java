package ua.com.yummzy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.yummzy.dto.DishDto;
import ua.com.yummzy.dto.RestaurantDto;
import ua.com.yummzy.exception.NotFoundException;
import ua.com.yummzy.mapper.DishMapper;
import ua.com.yummzy.mapper.RestaurantsMapper;
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
    public List<RestaurantDto> getAllRestaurants(Pageable pageable) {
        return restaurantRepository.findAll(pageable).getContent().stream()
                .map(restaurantsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantDto getRestaurantById(String id) {
        var restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Restaurant with id " + id + " not found!"));
        return restaurantsMapper.toDto(restaurant);
    }

    @Override
    public List<DishDto> getDishesByRestaurantId(String id, Pageable pageable) {
        return dishRepository.findAllByRestaurantId(id, pageable).stream()
                .map(dishMapper::toDto)
                .collect(Collectors.toList());
    }
}
