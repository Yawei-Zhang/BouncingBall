package ball;

import java.awt.*;

public class Ball {
    public static final int DEFAULT_RADIUS = 50;
    private int x;
    private int y;
    private int radius;

    private Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Ball(int x, int y) {
        this(x, y, DEFAULT_RADIUS);
    }

    public int getRadius() {
        return radius;
    }

    public Ball setRadius(int radius) {
        this.radius = radius;
        return this;
    }

    public Ball setCenter(Point point) {
        this.x = point.x;
        this.y = point.y;
        return this;
    }

    public Point getCenter() {
        return new Point(x, y);
    }
}
