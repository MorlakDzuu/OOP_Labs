import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineSegmentTest {

    private LineSegment lineSegment;

    @Before
    public void init() {
        lineSegment = new LineSegment(new Point(0, 2), new Point(5, 2), Integer.parseInt("ffff00", 16));
    }

    private static void assertEqualsDouble(double dob1, double dob2) {
        assertEquals(0, Double.compare(dob1, dob2));
    }

    @Test
    public void getPerimeter() {
        assertEqualsDouble(5, lineSegment.getPerimeter());
    }

    @Test
    public void getArea() {
        assertEqualsDouble(0, lineSegment.getArea());
    }

    @Test
    public void getOutlineColor() {
        assertEquals(Integer.parseInt("ffff00", 16), lineSegment.getOutlineColor());
    }

    @Test
    public void toStringTest() {
        assertEquals("line 0.0 2.0 5.0 2.0 ffff00", lineSegment.toString());
    }

    @Test
    public void invalidArguments() {
        try {
            lineSegment = new LineSegment(new Point(0, 0), new Point(0, 0));
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Start point and end point have the same coordinates", thrown.getMessage());
        }
    }

    @Test
    public void getPoint() {
        assertEquals("0.0 2.0", lineSegment.getStartPoint().toString());
        assertEquals("5.0 2.0", lineSegment.getEndPoint().toString());
    }
}