package ua.com.yummzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

//TODO: remove all commented code
@SpringBootApplication
//@RequiredArgsConstructor
@EnableMongoAuditing
public class YummzyApplication /*implements ApplicationRunner*/ {
//    private final RestaurantRepository restaurantRepository;
//    private final DishRepository dishRepository;

    public static void main(String[] args) {
        SpringApplication.run(YummzyApplication.class, args);
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        var random = new Random();
//        var restaurants = restaurantRepository.findAll();
//        var existDishes = dishRepository.findAll();
//        List<DishDocument> finalDishes = new ArrayList<>();
//
//        for (var dish : existDishes) {
//            dish.setRestaurant(restaurants.get(random.nextInt(restaurants.size())));
//            finalDishes.add(dish);
//        }
//
//        dishRepository.saveAll(finalDishes);
//
//        var r1 = restaurantRepository.save(createRestaurant("1", "Vasy 1", "desc1", Set.of("123", "321"), Set.of("address1", "address2")));
//        var r2 = restaurantRepository.save(createRestaurant("2", "Vasy 2", "desc2", Set.of("123", "321"), Set.of("address1", "address2")));
//        var r3 = restaurantRepository.save(createRestaurant("3", "Vasy 3", "desc3", Set.of("123", "321"), Set.of("address1", "address2")));
//
//        dishRepository.save(createDish("d10", Currency.UAH, BigDecimal.valueOf(666), "desc10", r3));
//        dishRepository.save(createDish("d2", Currency.UAH, BigDecimal.valueOf(100), "desc2", r1));
//        dishRepository.save(createDish("d3", Currency.UAH, BigDecimal.valueOf(100), "desc3", r1));
//        dishRepository.save(createDish("d4", Currency.UAH, BigDecimal.valueOf(100), "desc4", r1));
//        dishRepository.save(createDish("d5", Currency.UAH, BigDecimal.valueOf(100), "desc5", r2));
//        dishRepository.save(createDish("d6", Currency.UAH, BigDecimal.valueOf(100), "desc6", r2));
//        dishRepository.save(createDish("d7", Currency.UAH, BigDecimal.valueOf(100), "desc7", r2));
//        dishRepository.save(createDish("d8", Currency.UAH, BigDecimal.valueOf(100), "desc8", r3));
//    }

//    private RestaurantDocument createRestaurant(String name, String ownerName, String desc, Set<String> phones, Set<String> addresses) {
//        return RestaurantDocument.builder()
//                .name(name)
//                .description(desc)
//                .phones(phones)
//                .ownerName(ownerName)
//                .addresses(addresses)
//                .build();
//    }
//
//    private DishDocument createDish(String name, Currency currency, BigDecimal price, String desc, RestaurantDocument restaurant) {
//        return DishDocument.builder()
//                .name(name)
//                .currency(currency)
//                .price(price)
//                .description(desc)
//                .restaurant(restaurant)
//                .images(List.of(
//                        DishDocumentImage.builder()
//                                .position(1)
//                                .imageUrl("https://yummzy-dishes-images.s3.eu-central-1.amazonaws.com/dish4.jpg")
//                                .build(),
//                        DishDocumentImage.builder()
//                                .position(2)
//                                .imageUrl("https://yummzy-dishes-images.s3.eu-central-1.amazonaws.com/dish1.jpeg")
//                                .build()
//                ))
//                .build();
//    }
}
