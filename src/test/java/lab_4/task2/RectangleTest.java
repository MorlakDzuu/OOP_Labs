import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    Rectangle rectangle;

    @Before
    public void init() {
        rectangle = new Rectangle(new Point(2,12), 10, 100, "ff0000", "00ff00");
    }

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
    public void toStringTest() {
        assertEquals("rectangle 2.0 12.0 10.0 100.0 ff0000 ff00", rectangle.toString());
    }

    @Test
    public void getArea() {
        assertEquals(0, Double.compare(rectangle.getArea(), 1000));
    }

    @Test
    public void getPerimeter() {
        assertEquals(0, Double.compare(rectangle.getPerimeter(), 220));
    }


    @Test
    public void getRightBottom() {
        assertEquals("12.0 -88.0", rectangle.getRightBottom().toString());
    }

    @Test
    public void getWidth() {
        assertEquals(0, Double.compare(10, rectangle.getWidth()));
    }

    @Test
    public void getHeight() {
        assertEquals(0, Double.compare(100, rectangle.getHeight()));
    }

    @Test
    public void getColor() {
        assertEquals(Integer.parseInt("ff0000", 16), rectangle.getOutlineColor());
        assertEquals(Integer.parseInt("00ff00", 16), rectangle.getFillColor());
        rectangle = new Rectangle(new Point(0, 0), 10, 10);
        assertEquals(Color.BLACK.getRGB(), rectangle.getOutlineColor());
        assertEquals(Color.WHITE.getRGB(), rectangle.getFillColor());
    }

    @Test
    public void getLeftTop() {
        assertEquals("2.0 12.0", rectangle.getLeftTop().toString());
    }
}