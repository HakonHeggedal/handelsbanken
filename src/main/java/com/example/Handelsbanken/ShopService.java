package com.example.Handelsbanken;

import com.example.Handelsbanken.Objects.Cost;
import com.example.Handelsbanken.Objects.Watch;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ShopService {

    public final Watch rolex = new Watch("001", "Rolex", 100, 200, 3);
    public final Watch michaelKors = new Watch("002", "Michael Kors", 80, 120, 2);
    public final Watch swatch = new Watch("003", "Swatch", 50, 50, 1);
    public final Watch casio = new Watch("004", "Casio", 30, 30, 1);

    public Cost calculateCost(List<String> watchIDs) {
        Map<Watch, Long> watchCounts = watchIDs.stream()
                .map(this::getWatch)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

        watchCounts.forEach((watch, count) -> {

        });

        return new Cost(0);
    }

    public long getWatchGroupPrice(Watch watch, long count) {
        long numberOfDiscountGroups = count / watch.discountGroupSize();
        long remainingWatchesAfterDiscount = count % watch.discountGroupSize();

        return (numberOfDiscountGroups * watch.discountPrice()) + (remainingWatchesAfterDiscount * watch.unitPrice());
    }

    public Watch getWatch(String watchID) {
        return switch (watchID) {
            case "001" -> rolex;
            case "002" -> michaelKors;
            case "003" -> swatch;
            case "004" -> casio;
            default -> null; //TODO: logge denne penere
        };
    }

}
