package ua.com.yummzy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.yummzy.document.DishDocument;
import ua.com.yummzy.exception.NotFoundException;
import ua.com.yummzy.mapper.DishMapper;
import ua.com.yummzy.mapper.RestaurantMapper;
import ua.com.yummzy.rest.dto.DishDTO;
import ua.com.yummzy.repository.DishRepository;
import ua.com.yummzy.rest.dto.RestaurantDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class DefaultDishService implements DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;
    private final RestaurantMapper restaurantMapper;

    @Override
    public void create(DishDTO body) {
        var toCreate = dishMapper.toDocument(body);

        setRestaurantIfPresent(toCreate, body.getRestaurantDto());

        dishRepository.save(toCreate);
    }

    @Override
    public void update(DishDTO body, String id) {
        var toUpdate = dishMapper.toDocument(body);
        toUpdate.setId(id);

        setRestaurantIfPresent(toUpdate, body.getRestaurantDto());

        dishRepository.save(toUpdate);
    }

    @Override
    public DishDTO getById(String id) {
        var existDocument = dishRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("DishDocument with id " + id + " not found!"));
        var dishDto = dishMapper.toDto(existDocument);

        //TODO: Fix it (remove), this mechanism should work without it
        if (nonNull(existDocument.getRestaurant())) {
            dishDto.setRestaurantDto(restaurantMapper.toDto(existDocument.getRestaurant()));
        }

        return dishDto;
    }

    @Override
    public List<DishDTO> getAllRandom(int size) {
        return dishRepository.findAllRandom(size).stream()
                .map(dishMapper::toDto)
                .collect(Collectors.toList());
    }

    //TODO: Fix it (remove), this mechanism should work without it
    private void setRestaurantIfPresent(DishDocument dishDocument, RestaurantDTO restaurantDto) {
        Optional.ofNullable(restaurantDto)
                .ifPresent(dto -> {
                    var restaurantDocument = restaurantMapper.toDocument(dto);
                    restaurantDocument.setId(restaurantDto.getId());
                    dishDocument.setRestaurant(restaurantDocument);
                });
    }
}
