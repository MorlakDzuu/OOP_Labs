import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class GeometricTest {

    private geometric geometric;

    @Before
    public void ini() {
        geometric = new geometric();
    }

    @Test
    public void getRectangle() {
        assertNull(geometric.getRectangle(new ArrayList<>(Arrays.asList("1"))));
        assertNull(geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1"))));
        assertNull(geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1"))));

        assertEquals(new Rectangle(new Point(1, 1), 1, 1).toString(),
                     geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1"))).toString());

        assertEquals(new Rectangle(new Point(1, 1), 1, 1, 1).toString(),
                     geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1"))).toString());

        assertEquals(new Rectangle(new Point(1, 1), 1, 1, 1, 1).toString(),
                     geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1", "1"))).toString());

        assertNull(geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "h"))));
        assertNull(geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "h", "1"))));
        assertNull(geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "h", "1", "1"))));
        assertNull(geometric.getRectangle(new ArrayList<>(Arrays.asList("h", "1", "1", "1"))));
        assertNull(geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "lol"))));
        assertNull(geometric.getRectangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1", "lol"))));
    }

    @Test
    public void getTriangle() {
        assertNull(geometric.getTriangle(new ArrayList<>()));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("1"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "1"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "1", "2"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "1", "2", "2"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "1", "1"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("2", "1", "1", "1", "1", "1"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "2", "1", "1", "1"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "1", "1", "1", "2", "1"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "h"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "h", "2"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "h", "2", "2"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "h", "1", "2", "2"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "h", "2", "1", "2", "2"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("h", "2", "2", "1", "2", "2"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "lol"))));
        assertNull(geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "2", "lol"))));

        assertEquals(new Triangle(new Point(1, 2), new Point(2, 1), new Point(2, 2)).toString(),
                     geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2"))).toString());

        assertEquals(new Triangle(new Point(1, 2), new Point(2, 1), new Point(2, 2), 0xff).toString(),
                     geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "ff"))).toString());

        assertEquals(new Triangle(new Point(1, 2), new Point(2, 1), new Point(2, 2), 3, 0xff).toString(),
                     geometric.getTriangle(new ArrayList<>(Arrays.asList("1", "2", "2", "1", "2", "2", "3", "ff"))).toString());
    }

    @Test
    public void getCircle() {
        assertNull(geometric.getCircle(new ArrayList<>()));
        assertNull(geometric.getCircle(new ArrayList<>(Arrays.asList("0"))));
        assertNull(geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0"))));
        assertNull(geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0", "0"))));
        assertNull(geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0", "1", "lol"))));
        assertNull(geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0", "1", "1", "lol"))));

        assertEquals(new Circle(new Point(0.1, 0), 1).toString(),  geometric.getCircle(new ArrayList<>(Arrays.asList("0.1", "0", "1"))).toString());

        assertEquals(new Circle(new Point(0, 0), 1, 0xff).toString(),
                     geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0", "1", "ff"))).toString());

        assertEquals(new Circle(new Point(0, 0), 1, 0xff, 0xffff).toString(),
                     geometric.getCircle(new ArrayList<>(Arrays.asList("0", "0", "1", "ff", "ffff"))).toString());
    }

    @Test
    public void getLineSegment() {
        assertNull(geometric.getLineSegment(new ArrayList<>()));
        assertNull(geometric.getLineSegment(new ArrayList<>(Arrays.asList("0"))));
        assertNull(geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0"))));
        assertNull(geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0", "0"))));
        assertNull(geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0", "0", "0"))));
        assertNull(geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0", "0", "1", "lol"))));

        assertEquals(new LineSegment(new Point(0, 0), new Point(0, 1.1)).toString(),
                     geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0", "0", "1.1"))).toString());

        assertEquals(new LineSegment(new Point(0, 0), new Point(0, 1), 0xf0f0).toString(),
                geometric.getLineSegment(new ArrayList<>(Arrays.asList("0", "0", "0", "1", "f0f0"))).toString());
    }

    @Test
    public void getMaxAreaShape() {
        geometric.performCommand("triangle 0 0 3 0 0 4");
        geometric.performCommand("line 1 1 1 2");
        assertEquals(new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4)).toString(), geometric.getMaxAreaShape().toString());
    }

    @Test
    public void getMinPerimeterShape() {
        geometric.performCommand("triangle 0 0 3 0 0 4");
        geometric.performCommand("line 1 1 1 2");
        assertEquals(new LineSegment(new Point(1, 1), new Point(1, 2)).toString(), geometric.getMinPerimeterShape().toString());
    }
}