package behavior;

import ball.Ball;
import ball.ui.BallWorld;
import behavior.model.Direction;

import java.awt.*;

public class BounceBehavior implements Behavior {

    public static final int MOVEMENT_SPEED = 12;
    private final Ball ball;
    private int direction;

    public BounceBehavior(Ball ball, int direction) {
        this.ball = ball;
        this.direction = direction;
    }

    @Override
    public void behave() {
        if (isHitBottom() || isHitTop()) {
            reverseDirection();
        }
        ball.setCenter(new Point(ball.getCenter().x, ball.getCenter().y + direction * MOVEMENT_SPEED));
    }

    private boolean isHitBottom() {
        return direction == Direction.DOWN && ball.getCenter().y + ball.getRadius() >= BallWorld.BOX_HEIGHT;
    }

    private boolean isHitTop() {
        return direction == Direction.UP && ball.getCenter().y <= ball.getRadius();
    }

    private void reverseDirection() {
        direction = 0 - direction;
    }
}
