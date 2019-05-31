package behavior;

import ball.Ball;
import ball.ui.BallWorld;
import behavior.model.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BounceBehaviorTest {

    @Test
    public void shouldMoveDown() {
        //Given
        Ball ball = new Ball(75, 50);
        int originPosition = ball.getCenter().y;

        //When
        BounceBehavior bounceBehavior = new BounceBehavior(ball, Direction.DOWN);
        bounceBehavior.behave();

        //Then
        assertEquals(originPosition + BounceBehavior.MOVEMENT_SPEED, ball.getCenter().y);
    }

    @Test
    public void shouldMoveUp() {
        //Given
        Ball ball = new Ball(75, 100);
        int originPosition = ball.getCenter().y;

        //When
        BounceBehavior bounceBehavior = new BounceBehavior(ball, Direction.UP);
        bounceBehavior.behave();

        //Then
        assertEquals(originPosition - BounceBehavior.MOVEMENT_SPEED, ball.getCenter().y);
    }

    @Test
    public void shouldMoveUpAfterHittingBottom() {
        //Given
        int originPosition = BallWorld.BOX_HEIGHT - Ball.DEFAULT_RADIUS;
        Ball ball = new Ball(75, originPosition);

        //When
        BounceBehavior bounceBehavior = new BounceBehavior(ball, Direction.DOWN);
        bounceBehavior.behave();

        //Then
        assertEquals(originPosition - BounceBehavior.MOVEMENT_SPEED, ball.getCenter().y);
    }

    @Test
    public void shouldMovingDownAfterHittingTop() {
        //Given
        Ball ball = new Ball(75, Ball.DEFAULT_RADIUS);

        //When
        BounceBehavior bounceBehavior = new BounceBehavior(ball, Direction.UP);
        bounceBehavior.behave();

        //Then
        assertEquals(Ball.DEFAULT_RADIUS + BounceBehavior.MOVEMENT_SPEED, ball.getCenter().y);
    }
}
