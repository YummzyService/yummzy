package ua.com.yummzy.rest.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ua.com.yummzy.rest.dto.DishDTO;
import ua.com.yummzy.service.DishService;
import ua.com.yummzy.Constants;

import java.util.List;

@RestController
@RequestMapping(Constants.DISH)
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer")
public class DishController {
    private final DishService dishService;

    @ResponseStatus(value = HttpStatus.CREATED, reason = "DishDocument was created in DB")
    @PostMapping("/create")
    public void create(@RequestBody DishDTO body) {
        dishService.create(body);
    }

    @ResponseStatus(value = HttpStatus.OK, reason = "DishDocument was updated")
    @PutMapping("/{id}")
    public void update(@RequestBody DishDTO body, @PathVariable("id") String id) {
        dishService.update(body, id);
    }

    @GetMapping("/random")
    public List<DishDTO> getRandom(@RequestParam(defaultValue = "20") int size) {
        return dishService.getAllRandom(size);
    }

    @GetMapping("/{id}")
    public DishDTO getById(@PathVariable String id) {
        return dishService.getById(id);
    }
}
