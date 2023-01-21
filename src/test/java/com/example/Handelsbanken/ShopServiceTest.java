package com.example.Handelsbanken;

import com.example.Handelsbanken.Objects.Cost;
import com.example.Handelsbanken.Objects.Watch;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@RunWith(SpringRunner.class)
@ContextConfiguration()
class ShopServiceTest {


    ShopService shopService = new ShopService();

    @Test
    void calculateCost() {
        List<String> watchIDs = Arrays.asList("001", "002", "001", "004", "003");
        Cost cost = shopService.calculateCost(watchIDs);
        assertEquals(360, cost.price());
    }

    @Test
    void getWatchCasio() {
        Watch watch = shopService.getWatch(shopService.casio.watchID());
        assertEquals(shopService.casio, watch);
    }
    @Test
    void getWatchSwatch() {
        Watch watch = shopService.getWatch(shopService.swatch.watchID());
        assertEquals(shopService.swatch, watch);
    }

    @Test
    void getWatchMichaelKors() {
        Watch watch = shopService.getWatch(shopService.michaelKors.watchID());
        assertEquals(shopService.michaelKors, watch);
    }
    @Test
    void getWatchMichaelRolex() {
        Watch watch = shopService.getWatch(shopService.rolex.watchID());
        assertEquals(shopService.rolex, watch);
    }

    @Test
    void getGroupPrice() {
        long groupPrice = shopService.getWatchGroupPrice(shopService.rolex, 100);

        assertEquals(6700, groupPrice);
    }
}