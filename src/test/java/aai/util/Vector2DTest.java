package aai.util;

import junit.framework.TestCase;

public class Vector2DTest extends TestCase {

    public void testLength() {
        // Todo: Create some other examples that result in an integer length
        assertEquals(5.0, new Vector2D(3, 4).length());
        assertEquals(5.0, new Vector2D(4, 3).length());
    }

    public void testAdd() {
        var va = new Vector2D(2, 1);
        var vb = new Vector2D(1, 2);
        va.add(vb);
        assertEquals(3.0, va.x);
        assertEquals(3.0, va.y);
    }

    public void testDivide() {
        var va = new Vector2D(2, 1);
        va.divide(2);
        assertEquals(1.0, va.x);
        assertEquals(0.5, va.y);
    }

    public void testNormalize() {
        var va = new Vector2D(2, 1);
        va.normalize();
        assertEquals(1.0, va.length(), 0.000_001);
    }
}