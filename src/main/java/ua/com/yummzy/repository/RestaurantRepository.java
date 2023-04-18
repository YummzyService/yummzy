package ua.com.yummzy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.com.yummzy.document.Restaurant;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
    Page<Restaurant> findAll(Pageable pageable);
}
