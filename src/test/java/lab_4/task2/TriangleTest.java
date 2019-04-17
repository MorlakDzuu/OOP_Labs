import Classes.Point;
import Classes.Triangle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TriangleTest {

    private Triangle triangle;

    private void assertInvalidPointArguments(Classes.Point point1, Classes.Point point2, Classes.Point point3) {
        try {
            triangle = new Triangle(point1, point2, point3);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            assertEquals("Vertexes should not have the same coordinates", thrown.getMessage());
        }
    }

    @Before
    public void init() {
        triangle = new Triangle(new Classes.Point(0, 0), new Classes.Point(0, 3), new Classes.Point(4, 0),
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
        triangle = new Triangle(new Classes.Point(0, 0), new Classes.Point(0, 1), new Classes.Point(2, 3));
        assertEquals(Color.BLACK.getRGB(), triangle.getOutlineColor());
        assertEquals(Color.WHITE.getRGB(), triangle.getFillColor());
    }

    @Test
    public void toStringTest() {
        assertEquals("triangle 0.0 0.0 0.0 3.0 4.0 0.0 ff0000 ff00", triangle.toString());
    }

    @Test
    public void invalidArgument() {
        assertInvalidPointArguments(new Classes.Point(0, 0), new Classes.Point(0, 0), new Classes.Point(0, 0));
        assertInvalidPointArguments(new Classes.Point(0, 1), new Classes.Point(0, 0), new Classes.Point(0, 0));
        assertInvalidPointArguments(new Classes.Point(0, 0), new Classes.Point(1, 0), new Classes.Point(0, 0));
        assertInvalidPointArguments(new Classes.Point(0, 0), new Classes.Point(0, 0), new Classes.Point(0, 1));
    }

    @Test
    public void getVertex() {
        assertEquals("0.0 0.0", triangle.getVertex1().toString());
        assertEquals("0.0 3.0", triangle.getVertex2().toString());
        assertEquals("4.0 0.0", triangle.getVertex3().toString());
    }

    @Test
    public void draw() {
        Classes.Canvas canvasMock = mock(Classes.Canvas.class);
        Classes.Point vertex1 = new Classes.Point(0, 0);
        Classes.Point vertex2 = new Classes.Point(4, 0);
        Classes.Point vertex3 = new Point(0, 3);
        int outlineColor = 0xff;
        int fillColor = 0xfff000;
        Triangle triangle = new Triangle(vertex1, vertex2, vertex3, outlineColor, fillColor);
        triangle.draw(canvasMock);

        verify(canvasMock).drawLine(vertex1, vertex2, outlineColor);
        verify(canvasMock).drawLine(vertex2, vertex3, outlineColor);
        verify(canvasMock).drawLine(vertex3, vertex1, outlineColor);
        verify(canvasMock).fillPolygon(new ArrayList<>(Arrays.asList(vertex1, vertex2, vertex3)), fillColor);
    }
}