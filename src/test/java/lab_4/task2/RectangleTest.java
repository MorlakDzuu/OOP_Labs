import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    Rectangle rectangle;

    @Test
    public void illegalArguments() {
        try {
            rectangle = new Rectangle(new Point(2,12), 0, 10);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Width and height should be positive", thrown.getMessage());
        }
        try {
            rectangle = new Rectangle(new Point(2,12), 10, 0);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Width and height should be positive", thrown.getMessage());
        }
        try {
            rectangle = new Rectangle(new Point(2,12), 10, 5, "ftrg", "grve");
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Incorrect value of color", thrown.getMessage());
        }
    }

    @Test
    public void getArea() {
        rectangle = new Rectangle(new Point(2,12), 10, 10);
        assertEquals(0, Double.compare(rectangle.getArea(), 100));
        rectangle = new Rectangle(new Point(2,12), 0.1, 100);
        assertEquals(0, Double.compare(rectangle.getArea(), 10));
    }

    @Test
    public void getPerimeter() {
        rectangle = new Rectangle(new Point(2,12), 10, 10);
        assertEquals(0, Double.compare(rectangle.getPerimeter(), 40));
        rectangle = new Rectangle(new Point(2,12), 10, 100);
        assertEquals(0, Double.compare(rectangle.getPerimeter(), 220));
    }


    @Test
    public void getRightBottom() {
        rectangle = new Rectangle(new Point(2,12), 10, 10);
        assertEquals("12.0 2.0", rectangle.getRightBottom().toString());
        rectangle = new Rectangle(new Point(-1,-1), 5, 100);
        assertEquals("4.0 -101.0", rectangle.getRightBottom().toString());
    }

    @Test
    public void getWidth() {
        rectangle = new Rectangle(new Point(2,12), 10, 10);
        assertEquals(0, Double.compare(10, rectangle.getWidth()));
    }

    @Test
    public void getHeight() {
        rectangle = new Rectangle(new Point(2,12), 10, 10);
        assertEquals(0, Double.compare(10, rectangle.getHeight()));
    }

    @Test
    public void getColor() {
        rectangle = new Rectangle(new Point(0, 0), 10, 10);
        assertEquals(Color.BLACK.getRGB(), rectangle.getOutlineColor());
        assertEquals(Color.WHITE.getRGB(), rectangle.getFillColor());
        rectangle = new Rectangle(new Point(0, 0), 10, 10, "ff0000", "00ff00");
        assertEquals(Integer.parseInt("ff0000", 16), rectangle.getOutlineColor());
        assertEquals(Integer.parseInt("00ff00", 16), rectangle.getFillColor());
    }

    @Test
    public void getLeftTop() {
        rectangle = new Rectangle(new Point(1, 1), 10, 10);
        assertEquals("1.0 1.0", rectangle.getLeftTop().toString());
    }
}