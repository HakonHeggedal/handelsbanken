package com.example.Handelsbanken;

import com.example.Handelsbanken.objects.Cost;
import com.example.Handelsbanken.objects.Watch;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ShopService {

    private final Watch rolex = new Watch("001", "Rolex", 100);
    private final Watch michaelKors = new Watch("002", "Michael Kors", 80);
    private final Watch swatch = new Watch("003", "Swatch", 50);
    private final Watch casio = new Watch("004", "Casio", 30);

    public Cost calculateCost(ArrayList<String> watchIDs) {
        Map<Watch, Long> watchCounts = watchIDs.stream()
                .map(this::getWatch)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

        return new Cost(0);
    }

    private Watch getWatch(String watchID) {
        return switch (watchID)  {
            case "001" -> rolex;
            case "002"    -> michaelKors;
            case "003"  -> swatch;
            case "004"  -> casio;
            default        -> null;
        };
    }

}
