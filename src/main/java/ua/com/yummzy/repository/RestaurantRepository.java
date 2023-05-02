package ua.com.yummzy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.com.yummzy.document.RestaurantDocument;

@Repository
public interface RestaurantRepository extends MongoRepository<RestaurantDocument, String> {
}
