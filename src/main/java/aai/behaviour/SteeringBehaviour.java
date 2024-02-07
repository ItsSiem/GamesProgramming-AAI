package aai.behaviour;

import aai.entity.MovingEntity;
import aai.util.Vector2D;

/**
 * Created by gh0073874 on 13-2-2017.
 */
public abstract class SteeringBehaviour {

    protected MovingEntity entity;
    protected Vector2D target;

    public SteeringBehaviour(MovingEntity entity, Vector2D target) {
        this.entity = entity;
        this.target = target;
    }

    public abstract Vector2D calculate();

}
