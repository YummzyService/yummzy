package ua.com.yummzy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.com.yummzy.document.Dish;
import ua.com.yummzy.dto.DishDto;

@Mapper
public interface DishMapper {
    @Mapping(target = "id", ignore = true)
    Dish toDocument(DishDto dishDto);

    DishDto toDto(Dish dish);
}
