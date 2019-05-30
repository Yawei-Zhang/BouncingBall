package behavior;

import ball.Ball;
import ball.ui.BallWorld;

import java.awt.*;

public class BounceBehavior implements Behavior {

    public static final int MOVEMENT_SPEED = 12;
    private final Ball ball;
    private int direction = 1;

    public BounceBehavior(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void behave() {
        if (isHitBottom()) {
            this.direction = 0 - this.direction;
        }
        ball.setCenter(new Point(ball.getCenter().x, ball.getCenter().y + direction * MOVEMENT_SPEED));
    }

    private boolean isHitBottom() {
        return ball.getCenter().y + ball.getRadius() >= BallWorld.BOX_HEIGHT;
    }
}
