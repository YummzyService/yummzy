package ua.com.yummzy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.yummzy.common.exception.NotFoundException;
import ua.com.yummzy.common.mapper.DishMapper;
import ua.com.yummzy.common.mapper.RestaurantsMapper;
import ua.com.yummzy.common.rest.DishRestResponse;
import ua.com.yummzy.repository.DishRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultDishService implements DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;
    private final RestaurantsMapper restaurantsMapper;

    @Override
    public DishRestResponse getById(String id) {
        var dish = dishRepository.findById(id).orElseThrow(() ->
                new NotFoundException("DishDocument with id " + id + " not found!"));
        var dishDto = dishMapper.toResponse(dish);
        if (dish.getRestaurant() == null) {
            return dishDto;
        }
        var restaurantDto = restaurantsMapper.toResponse(dish.getRestaurant());
        dishDto.setRestaurantResponse(restaurantDto);
        return dishDto;
    }

    @Override
    public List<DishRestResponse> getAllRandom(int size) {
        return dishRepository.findAllRandom(size).stream()
                .map(dishMapper::toResponse)
                .collect(Collectors.toList());
    }
}
