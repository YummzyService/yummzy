package ua.com.yummzy.common.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "image")
public class DishImageDocument {
    @Field(name = "position")
    private int position;
    @Field(name = "image_url")
    private String imageUrl;
}
