package ua.com.yummzy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.com.yummzy.model.Dish;
import ua.com.yummzy.rest.dto.DishDTO;

@Mapper
public interface DishMapper {

    @Mapping(target = "id", ignore = true)
    Dish toDocument(DishDTO dto);

    DishDTO toDto(Dish document);
}
