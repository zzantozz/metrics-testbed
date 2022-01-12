package rds.metricsTestbed;

import java.util.concurrent.atomic.AtomicInteger;

public class Car extends AbstractRoadObject implements MovingThing, ColoredThing {
    private static AtomicInteger idGenerator = new AtomicInteger();
    private final int id;

    public Car(int speed, String color) {
        super(speed, color, 0, 0);
        this.id = idGenerator.getAndIncrement();
    }

    @Override
    public void tick() {
        this.addLengthProgress(this.getSpeed());
    }

    @Override
    public String toString() {
        return "Car " + id + "{" +
                "speed=" + getSpeed() +
                ", lengthPosition=" + getLengthPosition() +
                ", color='" + getColor() + '\'' +
                '}';
    }
}
