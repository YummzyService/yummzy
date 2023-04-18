package ua.com.yummzy.service;

import ua.com.yummzy.dto.DishDto;

import java.util.List;

public interface DishService {
    DishDto getById(String id);

    List<DishDto> getAllRandom(int size);
}
