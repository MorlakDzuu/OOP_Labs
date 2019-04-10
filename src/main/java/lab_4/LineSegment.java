import static java.lang.Math.sqrt;

public class LineSegment implements IShape {

    private Point startPoint;
    private Point endPoint;
    private int outlineColor;

    public LineSegment(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        outlineColor = 0;
    }

    public LineSegment(Point startPoint, Point endPoint, int outlineColor) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.outlineColor = outlineColor;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return sqrt(square(endPoint.getX() - startPoint.getX()) + square(endPoint.getY() - startPoint.getY()));
    }

    @Override
    public int getOutlineColor() {
        return outlineColor;
    }

    @Override
    public String toString() {
        return  "line " + startPoint.getX() + " " + startPoint.getY() + " " +
                endPoint.getX() + " " + endPoint.getY() + " " + Integer.toHexString(outlineColor);
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    private static double square(double a) {
        return a*a;
    }
}