package ua.com.yummzy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.com.yummzy.model.Restaurant;
import ua.com.yummzy.rest.dto.RestaurantDTO;

@Mapper
public interface RestaurantMapper {

    @Mapping(target = "id", ignore = true)
    Restaurant toDocument(RestaurantDTO dto);

    RestaurantDTO toDto(Restaurant document);
}
