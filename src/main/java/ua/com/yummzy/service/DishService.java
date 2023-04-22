package ua.com.yummzy.service;

import ua.com.yummzy.common.rest.DishRestResponse;

import java.util.List;

public interface DishService {
    DishRestResponse getById(String id);

    List<DishRestResponse> getAllRandom(int size);
}
