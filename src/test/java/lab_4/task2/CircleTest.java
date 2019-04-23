import Classes.Canvas;
import Classes.Circle;
import Classes.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CircleTest {

    private Circle circle;

    @Before
    public void init() {
        circle = new Circle(new Point(0, 0), 5, Integer.parseInt("ff00", 16), Integer.parseInt("fff000", 16));
    }

    @Test
    public void getFillColor() {
        assertEquals(Integer.parseInt("fff000", 16), circle.getFillColor());
    }

    @Test
    public void getArea() {
        assertEquals(0, Double.compare(Math.PI*25, circle.getArea()));
    }

    @Test
    public void getPerimeter() {
        assertEquals(1, Double.compare(Math.PI * 25, circle.getPerimeter()));
    }

    @Test
    public void getOutlineColor() {
        assertEquals(Integer.parseInt("ff00", 16), circle.getOutlineColor());
    }

    @Test
    public void getCenter() {
        assertEquals("0.0 0.0", circle.getCenter().toString());
    }

    @Test
    public void getRadius() {
        assertEquals(0, Double.compare(5, circle.getRadius()));
    }

    @Test
    public void getLength() {
        assertEquals(0, Double.compare(2 * Math.PI * 5, circle.getLength()));
    }

    @Test
    public void toStringTest() {
        assertEquals("circle 0.0 0.0 5.0 ff00 fff000", circle.toString());
    }

    @Test
    public void invalidArgument() {
        assertInvalidArgument(new Point(0, 0), 0);
        assertInvalidArgument(new Point(0, 0), -2);
    }

    @Test
    public void draw() {
        Canvas canvasMock = mock(Canvas.class);
        Point center = new Point(0, 0);
        double radius = 10;
        int outlineColor = 0xff;
        int fillColor = 0xab;
        Circle circle = new Circle(center, radius, outlineColor, fillColor);
        circle.draw(canvasMock);

        verify(canvasMock).drawCircle(center, radius, outlineColor);
        verify(canvasMock).fillCircle(center, radius, fillColor);
    }

    private void assertInvalidArgument(Point point, double radius) {
        try {
            circle = new Circle(point, radius);
            Assert.fail("Exception expected");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Radius should be positive", thrown.getMessage());
        }
    }
}