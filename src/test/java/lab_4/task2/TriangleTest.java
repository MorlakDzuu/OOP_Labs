import org.junit.Test;

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

        triangle = new Triangle(new Point(0, 0), new Point(0, 0), new Point(0, 0));
        assertEqualsDouble(0, triangle.getArea());

        triangle = new Triangle(new Point(0, 0), new Point(0, -3), new Point(-4, 0));
        assertEqualsDouble(6, triangle.getArea());
    }

    @Test
    public void getPerimeter() {
        triangle = new Triangle(new Point(0, 0), new Point(0, 3), new Point(4, 0));
        assertEqualsDouble(12, triangle.getPerimeter());

        triangle = new Triangle(new Point(0, 0), new Point(0, 0), new Point(0, 0));
        assertEqualsDouble(0, triangle.getPerimeter());

        triangle = new Triangle(new Point(0, 0), new Point(0, -3), new Point(-4, 0));
        assertEqualsDouble(12, triangle.getPerimeter());
    }
}