package ua.com.yummzy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.com.yummzy.document.DishDocument;
import ua.com.yummzy.rest.dto.DishDTO;

@Mapper
public interface DishMapper {

    @Mapping(target = "id", ignore = true)
    DishDocument toDocument(DishDTO dto);

    DishDTO toDto(DishDocument document);
}
