package ua.com.yummzy.common;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import ua.com.yummzy.common.mapper.DishMapper;
import ua.com.yummzy.common.rest.DishRestResponse;
import ua.com.yummzy.controller.DishController;
import ua.com.yummzy.controller.RestaurantController;
import ua.com.yummzy.repository.DishRepository;
import ua.com.yummzy.repository.RestaurantRepository;
import ua.com.yummzy.service.DishService;
import ua.com.yummzy.service.RestaurantService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@MockBeans({
        @MockBean(DishRepository.class),
        @MockBean(DishService.class),
        @MockBean(DishController.class),
        @MockBean(RestaurantRepository.class),
        @MockBean(RestaurantService.class),
        @MockBean(RestaurantController.class),
        @MockBean(MongoTemplate.class),
        @MockBean(GridFsTemplate.class),
})
@SpringBootTest
public class DishMaperTest {
    @Autowired
    private DishMapper dishMapper;

    @Test
    void fakeTestCase_shouldReturnNonNull_dishDocument() {
        var actual = dishMapper.toDocument(new DishRestResponse());
        assertNotNull(actual);
    }
}