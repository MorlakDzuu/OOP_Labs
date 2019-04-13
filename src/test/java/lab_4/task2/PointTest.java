import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    @Test
    public void getX() {
        Point point = new Point(1, 2);
        assertEquals(0, Double.compare(1, point.getX()));
    }

    @Test
    public void getY() {
        Point point = new Point(1, 2);
        assertEquals(0, Double.compare(2, point.getY()));
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