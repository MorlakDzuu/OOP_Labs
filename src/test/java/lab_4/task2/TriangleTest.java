import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TriangleTest {

    private Triangle triangle;

    private void assertInvalidPointArguments(Point point1, Point point2, Point point3) {
        try {
            triangle = new Triangle(point1, point2, point3);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Vertexes should not have the same coordinates", thrown.getMessage());
        }
    }

    @Before
    public void init() {
        triangle = new Triangle(new Point(0, 0), new Point(0, 3), new Point(4, 0),
                                Integer.parseInt("ff0000", 16), Integer.parseInt("ff00", 16));
    }

    private static void assertEqualsDouble(double dob1, double dob2) {
        assertEquals(0, Double.compare(dob1, dob2));
    }

    @Test
    public void getArea() {
        assertEqualsDouble(6, triangle.getArea());
    }

    @Test
    public void getPerimeter() {
        assertEqualsDouble(12, triangle.getPerimeter());
    }

    @Test
    public void getColor() {
        assertEquals(Integer.parseInt("ff0000", 16), triangle.getOutlineColor());
        assertEquals(Integer.parseInt("ff00", 16), triangle.getFillColor());
        triangle = new Triangle(new Point(0, 0), new Point(0, 1), new Point(2, 3));
        assertEquals(Color.BLACK.getRGB(), triangle.getOutlineColor());
        assertEquals(Color.WHITE.getRGB(), triangle.getFillColor());
    }

    @Test
    public void toStringTest() {
        assertEquals("triangle 0.0 0.0 0.0 3.0 4.0 0.0 ff0000 ff00", triangle.toString());
    }

    @Test
    public void invalidArgument() {
        assertInvalidPointArguments(new Point(0, 0), new Point(0, 0), new Point(0, 0));
        assertInvalidPointArguments(new Point(0, 1), new Point(0, 0), new Point(0, 0));
        assertInvalidPointArguments(new Point(0, 0), new Point(1, 0), new Point(0, 0));
        assertInvalidPointArguments(new Point(0, 0), new Point(0, 0), new Point(0, 1));
    }

    @Test
    public void getVertex() {
        assertEquals("0.0 0.0", triangle.getVertex1().toString());
        assertEquals("0.0 3.0", triangle.getVertex2().toString());
        assertEquals("4.0 0.0", triangle.getVertex3().toString());
    }
}