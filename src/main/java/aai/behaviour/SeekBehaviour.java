package aai.behaviour;

import aai.entity.MovingEntity;
import aai.util.Vector2D;

/**
 * Created by gh0073874 on 14-2-2017.
 */
public class SeekBehaviour extends SteeringBehaviour {

    public SeekBehaviour(MovingEntity entity, Vector2D target) {
        super(entity, target);
    }

    @Override
    public Vector2D calculate() {
        if (target == null) {
            return new Vector2D(0, 0);
        }

        var newTarget = new Vector2D(target.x, target.y);

        var desiredVelocity =  newTarget.sub(entity.getPosition()).normalize().multiply(entity.getMaxSpeed());
        return desiredVelocity.sub(entity.getVelocity());
    }
}
