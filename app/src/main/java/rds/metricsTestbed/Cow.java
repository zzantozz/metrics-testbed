package rds.metricsTestbed;

import java.util.concurrent.atomic.AtomicInteger;

public class Cow extends AbstractRoadObject implements MovingThing, ColoredThing {
    private static AtomicInteger idGenerator = new AtomicInteger();
    private final int id;

    public Cow(int speed, String color, int lengthPosition) {
        super(speed, color, 0, lengthPosition);
        this.id = idGenerator.getAndIncrement();
    }

    @Override
    public void tick() {
        this.addWidthProgress(this.getSpeed());
    }

    @Override
    public String toString() {
        return "Cow " + id + "{" +
                "speed=" + getSpeed() +
                ", widthPosition=" + getWidthPosition() +
                ", color='" + getColor() + '\'' +
                '}';
    }
}
