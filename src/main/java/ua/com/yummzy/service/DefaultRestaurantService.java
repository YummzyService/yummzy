package ua.com.yummzy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.yummzy.exception.NotFoundException;
import ua.com.yummzy.mapper.DishMapper;
import ua.com.yummzy.mapper.RestaurantMapper;
import ua.com.yummzy.rest.dto.DishDTO;
import ua.com.yummzy.rest.dto.RestaurantDTO;
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
    private final RestaurantMapper restaurantMapper;
    private final DishMapper dishMapper;

    @Override
    public void createRestaurant(RestaurantDTO body) {
        restaurantRepository.save(restaurantMapper.toDocument(body));
    }

    @Override
    public void updateRestaurant(RestaurantDTO body, String id) {
        var document = restaurantMapper.toDocument(body);
        document.setId(id);

        restaurantRepository.save(document);
    }

    @Override
    public List<RestaurantDTO> getRestaurants(Pageable pageable) {
        return restaurantRepository.findAll(pageable).getContent().stream()
                .map(restaurantMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantDTO getRestaurantById(String id) {
        var restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Restaurant document with id " + id + " not found!"));
        return restaurantMapper.toDto(restaurant);
    }

    @Override
    public List<DishDTO> getDishesByRestaurantId(String id, Pageable pageable) {
        return dishRepository.findAllByRestaurantId(id, pageable).stream()
                .map(dishMapper::toDto)
                .collect(Collectors.toList());
    }
}
