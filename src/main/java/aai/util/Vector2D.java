package aai.util;

import static java.lang.Math.sqrt;

/**
 * Created by gh0073874 on 13-2-2017.
 */
public class Vector2D {

    public double x;
    public double y;

    public Vector2D() {
        x = 0;
        y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double length() {
        return sqrt(x * x + y * y);
    }

    public Vector2D add(Vector2D v) {
        x += v.x;
        y += v.y;
        return this;
    }

    public Vector2D sub(Vector2D v) {
        x -= v.x;
        y -= v.y;
        return this;
    }

    public Vector2D multiply(double value) {
        this.x *= value;
        this.y *= value;
        return this;
    }

    public Vector2D divide(double value) {
        x /= value;
        y /= value;
        return this;
    }

    public Vector2D normalize() {
        double length = this.length();
        x /= length;
        y /= length;
        return this;
    }

    public Vector2D truncate(double max) {
        if (length() > max) {
            normalize();
            multiply(max);
        }
        return this;
    }

    @Override
    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", x, y);
    }
}