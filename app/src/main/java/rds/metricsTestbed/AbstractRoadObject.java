package rds.metricsTestbed;

public abstract class AbstractRoadObject {
    private int speed;
    private String color;
    private int widthPosition;
    private int lengthPosition;

    public AbstractRoadObject(int speed, String color, int widthPosition, int lengthPosition) {
        this.speed = speed;
        this.color = color;
        this.widthPosition = widthPosition;
        this.lengthPosition = lengthPosition;
    }

    public int getSpeed() {
        return speed;
    }

    public String getColor() {
        return color;
    }

    public void addWidthProgress(int progress) {
        widthPosition += progress;
    }

    public void addLengthProgress(int progress) {
        lengthPosition += progress;
    }

    public int getWidthPosition() {
        return widthPosition;
    }

    public int getLengthPosition() {
        return lengthPosition;
    }
}
