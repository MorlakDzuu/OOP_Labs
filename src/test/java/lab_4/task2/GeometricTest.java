import Classes.Geometric;
import Classes.LineSegment;
import Classes.Point;
import Classes.Triangle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeometricTest {

    private Geometric geometric;

    @Before
    public void init() {
        geometric = new Geometric();
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