import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TriangleTest {

    Triangle triangle;

    public static void assertEqualsDouble(double dob1, double dob2) {
        assertEquals(0, Double.compare(dob1, dob2));
    }

    @Test
    public void getArea() {
        triangle = new Triangle(new Point(0, 0), new Point(0, 3), new Point(4, 0));
        assertEqualsDouble(6, triangle.getArea());

        triangle = new Triangle(new Point(0, 0), new Point(0, -3), new Point(-4, 0));
        assertEqualsDouble(6, triangle.getArea());
    }

    @Test
    public void getPerimeter() {
        triangle = new Triangle(new Point(0, 0), new Point(0, 3), new Point(4, 0));
        assertEqualsDouble(12, triangle.getPerimeter());

        triangle = new Triangle(new Point(0, 0), new Point(0, -3), new Point(-4, 0));
        assertEqualsDouble(12, triangle.getPerimeter());
    }

    @Test
    public void getColor() {
        triangle = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1));
        assertEquals(Color.BLACK.getRGB(), triangle.getOutlineColor());
        assertEquals(Color.WHITE.getRGB(), triangle.getFillColor());
        triangle = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1), "ff0000", "00ff00");
        assertEquals(Integer.parseInt("ff0000", 16), triangle.getOutlineColor());
        assertEquals(Integer.parseInt("00ff00", 16), triangle.getFillColor());
    }

    @Test
    public void invalidArgument() {
        try {
            triangle = new Triangle(new Point(0, 0), new Point(0, 0), new Point(0, 0));
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Vertexes should not have the same coordinates", thrown.getMessage());
        }
        try {
            triangle = new Triangle(new Point(0, 1), new Point(0, 0), new Point(0, 0));
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Vertexes should not have the same coordinates", thrown.getMessage());
        }
        try {
            triangle = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 0));
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Vertexes should not have the same coordinates", thrown.getMessage());
        }
        try {
            triangle = new Triangle(new Point(0, 0), new Point(0, 0), new Point(0, 1));
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Vertexes should not have the same coordinates", thrown.getMessage());
        }
        try {
            triangle = new Triangle(new Point(1, 0), new Point(0, 0), new Point(0, 1), "hello", "hello");
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Incorrect value of color", thrown.getMessage());
        }
    }

    @Test
    public void getVertex() {
        triangle = new Triangle(new Point(1, 1), new Point(2, 2), new Point(3, 3));
        assertEquals("1.0 1.0", triangle.getVertex1().toString());
        assertEquals("2.0 2.0", triangle.getVertex2().toString());
        assertEquals("3.0 3.0", triangle.getVertex3().toString());
    }
}