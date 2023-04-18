package ua.com.yummzy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.yummzy.dto.DishDto;
import ua.com.yummzy.exception.NotFoundException;
import ua.com.yummzy.mapper.DishMapper;
import ua.com.yummzy.mapper.RestaurantsMapper;
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
    public DishDto getById(String id) {
        var dish = dishRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Dish with id " + id + " not found!"));
        var dishDto = dishMapper.toDto(dish);
        if (dish.getRestaurant() == null) {
            return dishDto;
        }
        var restaurantDto = restaurantsMapper.toDto(dish.getRestaurant());
        dishDto.setRestaurantDto(restaurantDto);
        return dishDto;
    }

    @Override
    public List<DishDto> getAllRandom(int size) {
        return dishRepository.findAllRandom(size).stream()
                .map(dishMapper::toDto)
                .collect(Collectors.toList());
    }
}
