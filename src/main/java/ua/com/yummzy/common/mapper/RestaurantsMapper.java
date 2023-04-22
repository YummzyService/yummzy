package ua.com.yummzy.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.com.yummzy.common.document.RestaurantDocument;
import ua.com.yummzy.common.rest.RestaurantRestResponse;

@Mapper
public interface RestaurantsMapper {

    @Mapping(target = "id", ignore = true)
    RestaurantDocument toDocument(RestaurantRestResponse response);

    RestaurantRestResponse toResponse(RestaurantDocument document);
}
