import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ShapeFactoryTest {

    private void assertShapeException(String shapeName, ArrayList<String> shapeArguments) {
        try {
            ShapeFactory shapeFactory = new ShapeFactory(shapeName, shapeArguments);
            shapeFactory.makeShape();
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            switch (shapeName) {
                case "rectangle":
                    assertEquals("Rectangle arguments exception", thrown.getMessage());
                    break;
                case "triangle":
                    assertEquals("Triangle arguments exception", thrown.getMessage());
                    break;
                case "circle":
                    assertEquals("Circle arguments exception", thrown.getMessage());
                    break;
                case "line":
                    assertEquals("Line arguments exception", thrown.getMessage());
                    break;
            }
        }
    }

    private void assertShape(IShape expected, ArrayList<String> shapeArguments) {
        String shapeName = expected.toString().split(" ")[0];
        ShapeFactory shapeFactory = new ShapeFactory(shapeName, shapeArguments);
        assertEquals(expected.toString(), shapeFactory.makeShape().toString());
    }

    @Test
    public void getRectangle() {
        assertShapeException("rectangle", new ArrayList<>(Arrays.asList("1")));
        assertShapeException("rectangle", new ArrayList(Arrays.asList("1", "1")));
        assertShapeException("rectangle", new ArrayList<>(Arrays.asList("1", "1", "1")));
        assertShapeException("rectangle", new ArrayList<>(Arrays.asList("1", "1", "1", "h")));
        assertShapeException("rectangle", new ArrayList<>(Arrays.asList("1", "1", "h", "1")));
        assertShapeException("rectangle", new ArrayList<>(Arrays.asList("1", "h", "1", "1")));
        assertShapeException("rectangle", new ArrayList<>(Arrays.asList("h", "1", "1", "1")));
        assertShapeException("rectangle", new ArrayList<>(Arrays.asList("1", "1", "1", "1", "lol")));
        assertShapeException("rectangle", new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1", "lol")));

        assertShape(new Rectangle(new Point(1, 1), 1, 1), new ArrayList<>(Arrays.asList("1", "1", "1", "1")));

        assertShape(new Rectangle(new Point(1, 1), 1, 1, 1),
                    new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1")));

        assertShape(new Rectangle(new Point(1, 1), 1, 1, 1, 1),
                    new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1", "1")));
    }

    @Test
    public void getTriangle() {
        assertShapeException("triangle", new ArrayList<>());
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("1")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("1", "1")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("1", "1", "1")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("1", "1", "1", "2")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("1", "1", "1", "2", "2")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1", "1")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("2", "1", "1", "1", "1", "1")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("1", "1", "2", "1", "1", "1")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("1", "1", "1", "1", "2", "1")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "h")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("1", "2", "2", "1", "h", "2")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("1", "2", "2", "h", "2", "2")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("1", "2", "h", "1", "2", "2")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("1", "h", "2", "1", "2", "2")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("h", "2", "2", "1", "2", "2")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "lol")));
        assertShapeException("triangle", new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "2", "lol")));

        assertShape(new Triangle(new Point(1, 2), new Point(2, 1), new Point(2, 2)),
                    new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2")));

        assertShape(new Triangle(new Point(1, 2), new Point(2, 1), new Point(2, 2), 0xff),
                   new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "ff")));

        assertShape(new Triangle(new Point(1, 2), new Point(2, 1), new Point(2, 2), 3, 0xff),
                     new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "3", "ff")));
    }

    @Test
    public void getCircle() {
        assertShapeException("circle", new ArrayList<>());
        assertShapeException("circle", new ArrayList<>(Arrays.asList("0")));
        assertShapeException("circle", new ArrayList<>(Arrays.asList("0", "0")));
        assertShapeException("circle", new ArrayList<>(Arrays.asList("0", "0", "0")));
        assertShapeException("circle", new ArrayList<>(Arrays.asList("0", "0", "1", "lol")));
        assertShapeException("circle", new ArrayList<>(Arrays.asList("0", "0", "1", "1", "lol")));

        assertShape(new Circle(new Point(0.1, 0), 1),  new ArrayList<>(Arrays.asList("0.1", "0", "1")));

        assertShape(new Circle(new Point(0, 0), 1, 0xff),
                    new ArrayList<>(Arrays.asList("0", "0", "1", "ff")));

        assertShape(new Circle(new Point(0, 0), 1, 0xff, 0xffff),
                    new ArrayList<>(Arrays.asList("0", "0", "1", "ff", "ffff")));
    }

    @Test
    public void getLineSegment() {
        assertShapeException("line", new ArrayList<>());
        assertShapeException("line", new ArrayList<>(Arrays.asList("0")));
        assertShapeException("line", new ArrayList<>(Arrays.asList("0", "0")));
        assertShapeException("line", new ArrayList<>(Arrays.asList("0", "0", "0")));
        assertShapeException("line", new ArrayList<>(Arrays.asList("0", "0", "0", "0")));
        assertShapeException("line", new ArrayList<>(Arrays.asList("0", "0", "0", "1", "lol")));

        assertShape(new LineSegment(new Point(0, 0), new Point(0, 1.1)),
                     new ArrayList<>(Arrays.asList("0", "0", "0", "1.1")));

        assertShape(new LineSegment(new Point(0, 0), new Point(0, 1), 0xf0f0),
                     new ArrayList<>(Arrays.asList("0", "0", "0", "1", "f0f0")));
    }
}