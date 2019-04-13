import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    Point point;

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
        assertEquals(false, point1.equals(point2));
        point2 = new Point(1, 2);
        assertEquals(false, point1.equals(point2));
        point2 = new Point(2, 1);
        assertEquals(false, point1.equals(point2));
        point2 = new Point(1, 1);
        assertEquals(true, point1.equals(point2));
    }
}