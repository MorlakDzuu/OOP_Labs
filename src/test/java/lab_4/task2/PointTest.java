import Classes.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    private Point point;

    @Before
    public void init() {
        point = new Point(1, 2);
    }

    @Test
    public void getX() {
        assertEquals(0, Double.compare(1, point.getX()));
    }

    @Test
    public void getY() {
        assertEquals(0, Double.compare(2, point.getY()));
    }

    @Test
    public void toStringTest() {
        assertEquals("1.0 2.0", point.toString());
    }

    @Test
    public void equals() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(2, 2);
        assertFalse(point1.equals(point2));
        point2 = new Point(1, 2);
        assertFalse(point1.equals(point2));
        point2 = new Point(2, 1);
        assertFalse(point1.equals(point2));
        point2 = new Point(1, 1);
        assertTrue(point1.equals(point2));
    }
}