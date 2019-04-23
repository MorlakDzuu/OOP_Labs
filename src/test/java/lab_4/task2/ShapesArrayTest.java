import Classes.*;
import Interfaces.IShape;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ShapesArrayTest {

    private ShapesArray shapesArray;

    @Before
    public void init() {
        shapesArray = new ShapesArray();
    }

    public void addShape(IShape shape) {
        ArrayList<String> shapeArguments = new ArrayList<>(Arrays.asList(shape.toString().split(" ")));
        String shapeName = shapeArguments.get(0);
        shapeArguments.remove(0);
        shapesArray.addShapeAndGetMessage(new ShapeFactory(shapeName, shapeArguments));
    }

    @Test
    public void getMaxAreaShape() {
        addShape(new Circle(new Point(0, 0), 3, 2, 3));
        addShape(new LineSegment(new Point(0, 0), new Point(3, 3), 2));
        Rectangle rectangle = new Rectangle(new Point(0, 10), 100, 100, 2, 3);
        addShape(rectangle);
        assertEquals(rectangle.toString(), shapesArray.getMaxAreaShape().toString());
    }

    @Test
    public void getMinPerimeterShape() {
        addShape(new Circle(new Point(0, 0), 3, 2, 3));
        LineSegment lineSegment = new LineSegment(new Point(0, 0), new Point(3, 3), 2);
        addShape(lineSegment);
        addShape(new Rectangle(new Point(0, 10), 100, 100, 2, 3));
        assertEquals(lineSegment.toString(), shapesArray.getMinPerimeterShape().toString());
    }

    @Test
    public void getInfoShape() {
        String string = "area: 120000.0\n" +
                        "perimeter: 1400.0\n" +
                        "outline color: ff\n" +
                        "fill color: ff00\n" +
                        "rectangle 50.0 100.0 400.0 300.0 ff ff00";
        assertEquals(string, shapesArray.getShapeInfo(new Rectangle(new Point(50, 100), 400, 300, Integer.parseInt("ff", 16), Integer.parseInt("ff00", 16))));
    }
}