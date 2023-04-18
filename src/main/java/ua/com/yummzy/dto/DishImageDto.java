package ua.com.yummzy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishImageDto {
    @JsonProperty(value = "position")
    private int position;
    @JsonProperty(value = "imageUrl")
    private String imageUrl;
}
