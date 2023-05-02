package ua.com.yummzy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.com.yummzy.document.RestaurantDocument;
import ua.com.yummzy.rest.dto.RestaurantDTO;

@Mapper
public interface RestaurantMapper {

    @Mapping(target = "id", ignore = true)
    RestaurantDocument toDocument(RestaurantDTO dto);

    RestaurantDTO toDto(RestaurantDocument document);
}
