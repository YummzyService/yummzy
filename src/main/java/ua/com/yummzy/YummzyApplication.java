package ua.com.yummzy;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import ua.com.yummzy.document.DishDocument;
import ua.com.yummzy.document.DishImageDocument;
import ua.com.yummzy.document.RestaurantDocument;
import ua.com.yummzy.meta.Currency;
import ua.com.yummzy.repository.DishRepository;
import ua.com.yummzy.repository.RestaurantRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.lang.String.valueOf;

//TODO: remove all commented code
@SpringBootApplication
@RequiredArgsConstructor
@EnableMongoAuditing
//public class YummzyApplication implements ApplicationRunner {
public class YummzyApplication {
    private final RestaurantRepository restaurantRepository;
    private final DishRepository dishRepository;

    public static void main(String[] args) {
        SpringApplication.run(YummzyApplication.class, args);
    }

    public void run(ApplicationArguments args) {
        var rand = new Random();
        var restaurants = restaurantRepository.findAll();
        var existDishes = dishRepository.findAll();

        List<DishDocument> finalDishes = new ArrayList<>();

        for (var dish : existDishes) {
            dish.setRestaurant(restaurants.get(rand.nextInt(restaurants.size())));
            finalDishes.add(dish);
        }

        dishRepository.saveAll(finalDishes);


        Stream.iterate(0, i -> i < 10, i -> i + 1)
                .map(i -> RestaurantDocument.builder()
                        .name(valueOf(i))
                        .ownerName(format("Owner restaurant name %s", i))
                        .description(format("Restaurant description %s", i))
                        .phones(Set.of(format("0%s", rand.nextInt(100 - 60) + 60), format("0%s", rand.nextInt(100 - 60) + 60)))
                        .addresses(Set.of(format("Restaurant address %s", i), format("Restaurant_%s address %s", i, i + 1)))
                        .build())
                .map(restaurantRepository::save)
                .flatMap(r -> Stream.iterate(1, j -> j < 5, j -> j + 1)
                        .map(j -> DishDocument.builder()
                                .name(format("Dish name %s_%s", j, r.getName()))
                                .currency(Currency.UAH)
                                .price(BigDecimal.valueOf(rand.nextInt(1000 - 100) + 100))
                                .description(format("Dish description %s_%s", j, r.getName()))
                                .restaurant(r)
                                .images(List.of(
                                        DishImageDocument.builder()
                                                .position(1)
                                                .imageUrl(format("https://yummzy-dishes-images.s3.eu-central-1.amazonaws.com/dish4_%s_%s.jpg",
                                                        j, r.getName()))
                                                .build(),
                                        DishImageDocument.builder()
                                                .position(2)
                                                .imageUrl(format("https://yummzy-dishes-images.s3.eu-central-1.amazonaws.com/dish1_%s_%s.jpeg",
                                                        j, r.getName()))
                                                .build()
                                ))
                                .build()
                        ))
                .forEach(dishRepository::save);
    }
}
