package aai.behaviour;

import aai.entity.MovingEntity;
import aai.util.Vector2D;

import static java.lang.Math.min;

public class ArriveBehaviour extends SteeringBehaviour{
    public ArriveBehaviour(MovingEntity entity, Vector2D target) {
        super(entity, target);
    }

    @Override
    public Vector2D calculate() {
        if (target == null) {
            return new Vector2D(0, 0);
        }
        var targetCopy = new Vector2D(target.x, target.y);

        var deceleration = 0.7;

        var toTarget = targetCopy.sub(entity.getPosition());
        var distance = toTarget.length();
        if (distance > 0) {
            var speed = distance / deceleration;

            speed = min(speed, entity.getMaxSpeed());


            var desiredVelocity = toTarget.multiply(speed).divide(distance);
            return desiredVelocity.sub(entity.getVelocity());
        }

        return new Vector2D(0, 0);
    }
}
