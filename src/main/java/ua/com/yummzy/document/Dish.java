package ua.com.yummzy.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;
import ua.com.yummzy.meta.Currency;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "dish")
public class Dish {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @Field(name = "name")
    private String name;
    @Field(name = "description")
    private String description;
    private List<DishImage> images = new ArrayList<>();
    @Field(name = "price", targetType = FieldType.DECIMAL128)
    private BigDecimal price;
    @Field(name = "currency")
    private Currency currency;
    @Indexed
    @Field(name = "restaurant_id", targetType = FieldType.OBJECT_ID)
    @DocumentReference(lazy = true)
    private Restaurant restaurant;
    @CreatedDate
    @Field(name = "create_at")
    private LocalDateTime createAt;
    @LastModifiedDate
    @Field(name = "update_at")
    private LocalDateTime updateAt;
}
