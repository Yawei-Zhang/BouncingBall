package behavior;

import ball.Ball;
import ball.ui.BallWorld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BounceBehaviorTest {

    @Test
    public void shouldMoveDown() {
        //Given
        Ball ball = new Ball(75, 50);
        int originPosition = ball.getCenter().y;

        //When
        BounceBehavior bounceBehavior = new BounceBehavior(ball);
        bounceBehavior.behave();

        //Then
        assertEquals(originPosition + BounceBehavior.MOVEMENT_SPEED, ball.getCenter().y);
    }

    @Test
    public void shouldReverseDirectionWhenBallHitsBottom() {
        //Given
        int originPosition = BallWorld.BOX_HEIGHT - Ball.DEFAULT_RADIUS;
        Ball ball = new Ball(75, originPosition);

        //When
        BounceBehavior bounceBehavior = new BounceBehavior(ball);
        bounceBehavior.behave();

        //Then
        assertEquals(originPosition - BounceBehavior.MOVEMENT_SPEED, ball.getCenter().y);
    }

    @Test
    public void shouldMovingDownAfterBallHitsTop() {
        //Given
        Ball ball = new Ball(75, Ball.DEFAULT_RADIUS);

        //When
        BounceBehavior bounceBehavior = new BounceBehavior(ball);
        bounceBehavior.reverseDirection();
        bounceBehavior.behave();

        //Then
        assertEquals(Ball.DEFAULT_RADIUS + BounceBehavior.MOVEMENT_SPEED, ball.getCenter().y);
    }
}
