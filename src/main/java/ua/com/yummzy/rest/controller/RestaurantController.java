package ua.com.yummzy.rest.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ua.com.yummzy.rest.dto.DishDTO;
import ua.com.yummzy.rest.dto.RestaurantDTO;
import ua.com.yummzy.service.RestaurantService;
import ua.com.yummzy.Constants;

import java.util.List;

@RestController
@RequestMapping(Constants.RESTAURANT)
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createRestaurant(@RequestBody RestaurantDTO body) {
        restaurantService.createRestaurant(body);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void updateRestaurant(@RequestBody RestaurantDTO body, @PathVariable("id") String id) {
        restaurantService.updateRestaurant(body, id);
    }

    @GetMapping
    @PageableAsQueryParam
    public List<RestaurantDTO> getRestaurants(@Parameter(hidden = true) @PageableDefault(size = 20) Pageable pageable) {
        return restaurantService.getRestaurants(pageable);
    }

    @GetMapping("/{id}")
    public RestaurantDTO getRestaurantById(@PathVariable String id) {
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping("/{id}/dishes")
    @PageableAsQueryParam
    public List<DishDTO> getDishesByRestaurantId(@PathVariable String id,
                                                 @Parameter(hidden = true) @PageableDefault(size = 20) Pageable pageable) {
        return restaurantService.getDishesByRestaurantId(id, pageable);
    }
}
