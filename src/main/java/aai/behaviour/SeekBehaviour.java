package aai.behaviour;

import aai.entity.MovingEntity;
import aai.util.Vector2D;

/**
 * Created by gh0073874 on 14-2-2017.
 */
public class SeekBehaviour extends SteeringBehaviour {

    public SeekBehaviour(MovingEntity entity) {
        super(entity);
    }

    @Override
    public Vector2D calculate() {
        // TODO: implement
        return new Vector2D(0,0);
    }
}
