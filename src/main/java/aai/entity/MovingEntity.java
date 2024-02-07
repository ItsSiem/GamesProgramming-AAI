package aai.entity;

import aai.behaviour.SteeringBehaviour;
import aai.util.Vector2D;
import aai.world.World;

import java.awt.*;

/**
 * Created by gh0073874 on 13-2-2017.
 */
public abstract class MovingEntity extends BaseEntity {

    protected Vector2D velocity;

    protected double mass;
    protected double maxSpeed;

    protected SteeringBehaviour behaviour;

    public MovingEntity(Vector2D position, World world) {
        super(position, world);

        this.velocity = new Vector2D();

        this.mass = 1;
        this.maxSpeed = 150;
    }

    @Override
    public void update(float delta) {
        // TODO: implement
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        super.render(g);
        g.setColor(Color.CYAN);
        g.drawLine((int)position.x, (int)position.y, (int) position.x + (int) (velocity.x * 25), (int) position.y + (int)(velocity.y * 25));
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public void setBehaviour(SteeringBehaviour behaviour) {
        this.behaviour = behaviour;
    }
}