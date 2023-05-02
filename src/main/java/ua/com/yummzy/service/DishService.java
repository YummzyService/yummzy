package ua.com.yummzy.service;

import ua.com.yummzy.rest.dto.DishDTO;

import java.util.List;

public interface DishService {

    void create(DishDTO body);

    void update(DishDTO body, String id);

    DishDTO getById(String id);

    List<DishDTO> getAllRandom(int size);
}
