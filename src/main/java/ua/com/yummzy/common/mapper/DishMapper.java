package ua.com.yummzy.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.com.yummzy.common.document.DishDocument;
import ua.com.yummzy.common.rest.DishRestResponse;

@Mapper
public interface DishMapper {

    @Mapping(target = "id", ignore = true)
    DishDocument toDocument(DishRestResponse response);

    DishRestResponse toResponse(DishDocument document);
}
