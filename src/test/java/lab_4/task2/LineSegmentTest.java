import org.junit.Assert;
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
        assertEqualsDouble(5, lineSegment.getLength());
        lineSegment = new LineSegment(new Point(0, 3), new Point(4, 0));
        assertEqualsDouble(5, lineSegment.getLength());
    }

    @Test
    public void getArea() {
        lineSegment = new LineSegment(new Point(0, 2), new Point(5, 2));
        assertEqualsDouble(0, lineSegment.getArea());
    }

    @Test
    public void getOutlineColor() {
        lineSegment = new LineSegment(new Point(0, 1), new Point(0,0), "ffff00");
        assertEquals(Integer.parseInt("ffff00", 16), lineSegment.getOutlineColor());
    }

    @Test
    public void invalidArguments() {
        try {
            lineSegment = new LineSegment(new Point(0, 0), new Point(0, 0));
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Start point and end point have the same coordinates", thrown.getMessage());
        }
        try {
            lineSegment = new LineSegment(new Point(1, 1), new Point(0, 0), "grege");
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Incorrect value of color", thrown.getMessage());
        }
    }

    @Test
    public void getPoint() {
        lineSegment = new LineSegment(new Point(1, 1), new Point(10, 11));
        assertEquals("1.0 1.0", lineSegment.getStartPoint().toString());
        assertEquals("10.0 11.0", lineSegment.getEndPoint().toString());
    }
}