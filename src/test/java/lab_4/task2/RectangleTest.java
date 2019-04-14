import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RectangleTest {

    private Rectangle rectangle;

    private void assertInvalidArguments(Point point, double width, double height) {
        try {
            rectangle = new Rectangle(point, width, height);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Width and height should be positive", thrown.getMessage());
        }
    }

    @Before
    public void init() {
        rectangle = new Rectangle(new Point(2,12), 10, 100,
                                  Integer.parseInt("ff0000", 16), Integer.parseInt("00ff00", 16));
    }

    @Test
    public void illegalArguments() {
        assertInvalidArguments(new Point(2,12), 0, 10);
        assertInvalidArguments(new Point(2,12), 10, 0);
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
        assertEquals("12.0 112.0", rectangle.getRightBottom().toString());
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

    @Test
    public void draw() {
        Canvas canvasMock = mock(Canvas.class);
        Point leftTopPoint = new Point(0, 0);
        Point rightTopPoint = new Point(10, 0);
        Point rightBottomPoint = new Point(10, 100);
        Point leftBottomPoint = new Point(0, 100);
        double width = 10;
        double height = 100;
        int outlineColor = 0xf3;
        int fillColor = 0xfab;
        Rectangle rectangle = new Rectangle(leftTopPoint, width, height, outlineColor, fillColor);
        rectangle.draw(canvasMock);

        verify(canvasMock).drawLine(leftTopPoint, rightTopPoint, outlineColor);
        verify(canvasMock).drawLine(rightTopPoint, rightBottomPoint, outlineColor);
        verify(canvasMock).drawLine(rightBottomPoint, leftBottomPoint, outlineColor);
        verify(canvasMock).drawLine(leftBottomPoint, leftTopPoint, outlineColor);
        verify(canvasMock).fillPolygon(new ArrayList<>(Arrays.asList(leftTopPoint, leftBottomPoint, rightBottomPoint, rightTopPoint)), fillColor);
    }
}