import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircleTest {

    private Circle circle;

    @Test
    public void getFillColor() {
        circle = new Circle(new Point(0, 0), 5, "ff00", "fff000");
        assertEquals(Integer.parseInt("fff000", 16), circle.getFillColor());
    }

    @Test
    public void getArea() {
        circle = new Circle(new Point(0, 0), 5);
        assertEquals(0, Double.compare(Math.PI*25, circle.getArea()));
    }

    @Test
    public void getPerimeter() {
        circle = new Circle(new Point(0, 0), 5);
        assertEquals(0, Double.compare(0, circle.getPerimeter()));
    }

    @Test
    public void getOutlineColor() {
        circle = new Circle(new Point(0, 0), 5, "ff00", "fff000");
        assertEquals(Integer.parseInt("ff00", 16), circle.getOutlineColor());
    }

    @Test
    public void getCenter() {
        circle = new Circle(new Point(0, 0), 5);
        assertEquals("0.0 0.0", circle.getCenter().toString());
    }

    @Test
    public void getRadius() {
        circle = new Circle(new Point(0, 0), 5);
        assertEquals(0, Double.compare(5, circle.getRadius()));
    }

    @Test
    public void getLength() {
        circle = new Circle(new Point(0, 0), 5);
        assertEquals(0, Double.compare(2 * Math.PI * 5, circle.getLength()));
    }

    @Test
    public void invalidArgument() {
        try {
            circle = new Circle(new Point(0, 0), 0);
            Assert.fail("Exception expected");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Radius should be positive", thrown.getMessage());
        }
        try {
            circle = new Circle(new Point(0, 0), -2);
            Assert.fail("Exception expected");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Radius should be positive", thrown.getMessage());
        }
        try {
            circle = new Circle(new Point(0, 0), 2, "fere", "wfw");
            Assert.fail("Exception expected");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Incorrect value of color", thrown.getMessage());
        }
        try {
            circle = new Circle(new Point(0, 0), 2, "fere", "ffff");
            Assert.fail("Exception expected");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Incorrect value of color", thrown.getMessage());
        }
        try {
            circle = new Circle(new Point(0, 0), 2, "ffff", "wfw");
            Assert.fail("Exception expected");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Incorrect value of color", thrown.getMessage());
        }
    }
}