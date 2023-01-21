package com.example.Handelsbanken;

import com.example.Handelsbanken.objects.Cost;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("")
class ShopController {

    private final ShopService service;

    ShopController(ShopService service) {
        this.service = service;
    }

    @PostMapping("checkout")
    @ResponseStatus(HttpStatus.CREATED)
    public Cost findCost(@RequestBody @NonNull ArrayList<String> watchIDs) {
        return service.calculateCost(watchIDs);
    }

    @GetMapping("ping")
    @ResponseStatus(HttpStatus.CREATED)
    public String ping() {
        return "pong";
    }

}