package ua.com.yummzy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.com.yummzy.common.document.RestaurantDocument;

@Repository
public interface RestaurantRepository extends MongoRepository<RestaurantDocument, String> {
    Page<RestaurantDocument> findAll(Pageable pageable);
}
