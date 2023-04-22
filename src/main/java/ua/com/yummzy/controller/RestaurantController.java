package ua.com.yummzy.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.yummzy.common.rest.DishRestResponse;
import ua.com.yummzy.common.rest.RestaurantRestResponse;
import ua.com.yummzy.service.RestaurantService;
import ua.com.yummzy.common.Constants;

import java.util.List;

@RestController
@RequestMapping(Constants.RESTAURANT)
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping
    @PageableAsQueryParam
    public List<RestaurantRestResponse> getRestaurants(@Parameter(hidden = true) @PageableDefault(size = 20) Pageable pageable) {
        return restaurantService.getAllRestaurants(pageable);
    }

    @GetMapping("/{id}")
    public RestaurantRestResponse getRestaurants(@PathVariable String id) {
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping("/{id}/dishes")
    @PageableAsQueryParam
    public List<DishRestResponse> getDishes(@PathVariable String id,
                                            @Parameter(hidden = true) @PageableDefault(size = 20) Pageable pageable) {
        return restaurantService.getDishesByRestaurantId(id, pageable);
    }
}
