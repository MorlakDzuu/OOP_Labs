import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class GeometricTest {

    @Test
    public void getRectangle() {
        assertEquals(null, Geometric.getRectangle(new ArrayList<>(Arrays.asList("1"))));
        assertEquals(null, Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1"))));
        assertEquals(null, Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1"))));

        assertEquals(new Rectangle(new Point(1, 1), 1, 1).toString(),
                     Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1"))).toString());

        assertEquals(new Rectangle(new Point(1, 1), 1, 1, 1).toString(),
                     Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1"))).toString());

        assertEquals(new Rectangle(new Point(1, 1), 1, 1, 1, 1).toString(),
                     Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1", "1"))).toString());

        assertEquals(null, Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "h"))));
        assertEquals(null, Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "h", "1"))));
        assertEquals(null, Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "h", "1", "1"))));
        assertEquals(null, Geometric.getRectangle(new ArrayList<>(Arrays.asList("h", "1", "1", "1"))));
        assertEquals(null, Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "lol"))));
        assertEquals(null, Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1", "lol"))));
    }

    @Test
    public void getTriangle() {
        assertEquals(null, Geometric.getTriangle(new ArrayList<>()));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("1"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "1"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "1", "2"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "1", "2", "2"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1", "1"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("2", "1", "1", "1", "1", "1"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "2", "1", "1", "1"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "2", "1"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "h"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "h", "2"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "h", "2", "2"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "h", "1", "2", "2"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "h", "2", "1", "2", "2"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("h", "2", "2", "1", "2", "2"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "lol"))));
        assertEquals(null, Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "2", "lol"))));

        assertEquals(new Triangle(new Point(1, 2), new Point(2, 1), new Point(2, 2)).toString(),
                     Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2"))).toString());

        assertEquals(new Triangle(new Point(1, 2), new Point(2, 1), new Point(2, 2), 0xff).toString(),
                     Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "ff"))).toString());

        assertEquals(new Triangle(new Point(1, 2), new Point(2, 1), new Point(2, 2), 3, 0xff).toString(),
                     Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "3", "ff"))).toString());
    }

    @Test
    public void getCircle() {
        assertEquals(null, Geometric.getCircle(new ArrayList<>()));
        assertEquals(null, Geometric.getCircle(new ArrayList<>(Arrays.asList("0"))));
        assertEquals(null, Geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0"))));
        assertEquals(null, Geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0", "0"))));
        assertEquals(null, Geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0", "1", "lol"))));
        assertEquals(null, Geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0", "1", "1", "lol"))));

        assertEquals(new Circle(new Point(0.1, 0), 1).toString(),  Geometric.getCircle(new ArrayList<>(Arrays.asList("0.1", "0", "1"))).toString());

        assertEquals(new Circle(new Point(0, 0), 1, 0xff).toString(),
                     Geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0", "1", "ff"))).toString());

        assertEquals(new Circle(new Point(0, 0), 1, 0xff, 0xffff).toString(),
                     Geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0", "1", "ff", "ffff"))).toString());
    }

    @Test
    public void getLineSegment() {
        assertEquals(null, Geometric.getLineSegment(new ArrayList<>()));
        assertEquals(null, Geometric.getLineSegment(new ArrayList<>(Arrays.asList("0"))));
        assertEquals(null, Geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0"))));
        assertEquals(null, Geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0", "0"))));
        assertEquals(null, Geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0", "0", "0"))));
        assertEquals(null, Geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0", "0", "1", "lol"))));

        assertEquals(new LineSegment(new Point(0, 0), new Point(0, 1.1)).toString(),
                     Geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0", "0", "1.1"))).toString());

        assertEquals(new LineSegment(new Point(0, 0), new Point(0, 1), 0xf0f0).toString(),
                Geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0", "0", "1", "f0f0"))).toString());
    }
}