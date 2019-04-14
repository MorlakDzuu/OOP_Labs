import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class GeometricTest {

    @Test
    public void getRectangle() {
        assertNull(Geometric.getRectangle(new ArrayList<>(Arrays.asList("1"))));
        assertNull(Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1"))));
        assertNull(Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1"))));

        assertEquals(new Rectangle(new Point(1, 1), 1, 1).toString(),
                     Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1"))).toString());

        assertEquals(new Rectangle(new Point(1, 1), 1, 1, 1).toString(),
                     Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1"))).toString());

        assertEquals(new Rectangle(new Point(1, 1), 1, 1, 1, 1).toString(),
                     Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1", "1"))).toString());

        assertNull(Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "h"))));
        assertNull(Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "h", "1"))));
        assertNull(Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "h", "1", "1"))));
        assertNull(Geometric.getRectangle(new ArrayList<>(Arrays.asList("h", "1", "1", "1"))));
        assertNull(Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "lol"))));
        assertNull(Geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1", "lol"))));
    }

    @Test
    public void getTriangle() {
        assertNull(Geometric.getTriangle(new ArrayList<>()));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("1"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "1"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "1", "2"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "1", "2", "2"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1", "1"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("2", "1", "1", "1", "1", "1"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "2", "1", "1", "1"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "2", "1"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "h"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "h", "2"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "h", "2", "2"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "h", "1", "2", "2"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "h", "2", "1", "2", "2"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("h", "2", "2", "1", "2", "2"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "lol"))));
        assertNull(Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "2", "lol"))));

        assertEquals(new Triangle(new Point(1, 2), new Point(2, 1), new Point(2, 2)).toString(),
                     Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2"))).toString());

        assertEquals(new Triangle(new Point(1, 2), new Point(2, 1), new Point(2, 2), 0xff).toString(),
                     Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "ff"))).toString());

        assertEquals(new Triangle(new Point(1, 2), new Point(2, 1), new Point(2, 2), 3, 0xff).toString(),
                     Geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "3", "ff"))).toString());
    }

    @Test
    public void getCircle() {
        assertNull(Geometric.getCircle(new ArrayList<>()));
        assertNull(Geometric.getCircle(new ArrayList<>(Arrays.asList("0"))));
        assertNull(Geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0"))));
        assertNull(Geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0", "0"))));
        assertNull(Geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0", "1", "lol"))));
        assertNull(Geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0", "1", "1", "lol"))));

        assertEquals(new Circle(new Point(0.1, 0), 1).toString(),  Geometric.getCircle(new ArrayList<>(Arrays.asList("0.1", "0", "1"))).toString());

        assertEquals(new Circle(new Point(0, 0), 1, 0xff).toString(),
                     Geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0", "1", "ff"))).toString());

        assertEquals(new Circle(new Point(0, 0), 1, 0xff, 0xffff).toString(),
                     Geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0", "1", "ff", "ffff"))).toString());
    }

    @Test
    public void getLineSegment() {
        assertNull(Geometric.getLineSegment(new ArrayList<>()));
        assertNull(Geometric.getLineSegment(new ArrayList<>(Arrays.asList("0"))));
        assertNull(Geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0"))));
        assertNull(Geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0", "0"))));
        assertNull(Geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0", "0", "0"))));
        assertNull(Geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0", "0", "1", "lol"))));

        assertEquals(new LineSegment(new Point(0, 0), new Point(0, 1.1)).toString(),
                     Geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0", "0", "1.1"))).toString());

        assertEquals(new LineSegment(new Point(0, 0), new Point(0, 1), 0xf0f0).toString(),
                Geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0", "0", "1", "f0f0"))).toString());
    }

    @Test
    public void getMaxAreaShape() {}
    
}