package rds.metricsTestbed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Road {
    private static final Logger logger = LoggerFactory.getLogger(Road.class);

    private final Metrics metrics;
    private final int width;
    private final int length;
    private final List<Cow> cows;
    private final List<Car> cars;

    public Road(Metrics metrics, int width, int length) {
        logger.info("Creating a road " + length + "x" + width);
        this.metrics = metrics;
        this.width = width;
        this.length = length;
        cows = new CopyOnWriteArrayList<>();
        cars = new CopyOnWriteArrayList<>();
    }

    public void tick() {
//        System.out.println("Check " + cars.size() + " cars vs " + cows.size() + " cows");
        cows.forEach(cow -> {
            cow.tick();
            if (cow.getWidthPosition() > this.width) {
                metrics.escaped(cow);
                cows.remove(cow);
            }
        });
        cars.forEach(car -> {
            int start = car.getLengthPosition();
            car.tick();
            int end = car.getLengthPosition();
            cows.forEach(cow -> {
                // if car overlapped cow, it's a hit; ignore width for simplicity
                if (start <= cow.getLengthPosition() && end >= cow.getLengthPosition()) {
                    metrics.hit(car, cow);
                    cows.remove(cow);
                    cars.remove(car); // because really, a cow? the car would be totalled
                }
            });
            if (car.getLengthPosition() > this.length) {
                metrics.escaped(car);
                cars.remove(car);
            }
        });
    }

    public void add(Car car) {
        cars.add(car);
    }

    public void add(Cow cow) {
        cows.add(cow);
    }
}
