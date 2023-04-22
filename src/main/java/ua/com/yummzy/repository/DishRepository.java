package ua.com.yummzy.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.yummzy.common.document.DishDocument;

import java.util.List;

@Repository
public interface DishRepository extends MongoRepository<DishDocument, String> {

    List<DishDocument> findAllByRestaurantId(String restaurantId, Pageable pageable);

    @Aggregation("{ $sample: { size: ?0 } }")
    List<DishDocument> findAllRandom(@Param("size") int size);
}
