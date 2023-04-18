package ua.com.yummzy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.yummzy.meta.Currency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {
    @JsonProperty(value = "id")
    private String id;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "description")
    private String description;
    @JsonProperty(value = "images")
    private List<DishImageDto> images = new ArrayList<>();
    @JsonProperty(value = "price")
    private BigDecimal price;
    @JsonProperty(value = "currency")
    private Currency currency;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "restaurant")
    private RestaurantDto restaurantDto;
}
