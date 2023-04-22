package ua.com.yummzy.common.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "restaurant")
public class Restaurant {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @Field(name = "name")
    private String name;
    @Field(name = "description")
    private String description;
    @Field(name = "addresses")
    private Set<String> addresses;
    @Field(name = "phones")
    private Set<String> phones;
    @Field(name = "ownerName")
    private String ownerName;
    @CreatedDate
    @Field(name = "create_at")
    private LocalDateTime createAt;
    @LastModifiedDate
    @Field(name = "update_at")
    private LocalDateTime updateAt;
}
