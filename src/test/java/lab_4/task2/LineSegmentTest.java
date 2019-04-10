import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineSegmentTest {

    LineSegment lineSegment;

    public static void assertEqualsDouble(double dob1, double dob2) {
        assertEquals(0, Double.compare(dob1, dob2));
    }

    @Test
    public void getPerimeter() {
        lineSegment = new LineSegment(new Point(0, 2), new Point(5, 2));
        assertEqualsDouble(5, lineSegment.getPerimeter());
        lineSegment = new LineSegment(new Point(0, 3), new Point(4, 0));
        assertEqualsDouble(5, lineSegment.getPerimeter());
        lineSegment = new LineSegment(new Point(0, 0), new Point(0, 0));
        assertEqualsDouble(0, lineSegment.getPerimeter());
    }

    @Test
    public void getArea() {
        lineSegment = new LineSegment(new Point(0, 2), new Point(5, 2));
        assertEqualsDouble(0, lineSegment.getArea());
        lineSegment = new LineSegment(new Point(0, 0), new Point(0, 0));
        assertEqualsDouble(0, lineSegment.getArea());
    }
}