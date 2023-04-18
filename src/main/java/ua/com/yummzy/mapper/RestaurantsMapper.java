package ua.com.yummzy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.com.yummzy.document.Restaurant;
import ua.com.yummzy.dto.RestaurantDto;

@Mapper
public interface RestaurantsMapper {
    RestaurantDto toDto(Restaurant restaurant);

    @Mapping(target = "id", ignore = true)
    Restaurant toDocument(RestaurantDto restaurantDto);
}
