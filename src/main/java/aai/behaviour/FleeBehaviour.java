package aai.behaviour;

import aai.entity.MovingEntity;
import aai.util.Vector2D;

public class FleeBehaviour extends SteeringBehaviour{
    public FleeBehaviour(MovingEntity entity, Vector2D target) {
        super(entity, target);
    }
    @Override
    public Vector2D calculate() {
        var fleeDistance = 300;
        if (target == null || target.distance(entity.getPosition()) > fleeDistance) {
            return new Vector2D(0, 0);
        }

        var targetCopy = new Vector2D(target.x, target.y);
        var entityPosition = new Vector2D(entity.getPosition().x, entity.getPosition().y);

        var desiredVelocity =  entityPosition.sub(targetCopy).normalize().multiply(entity.getMaxSpeed());
        return desiredVelocity.sub(entity.getVelocity());
    }
}
