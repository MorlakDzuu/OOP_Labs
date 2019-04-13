import static java.lang.Math.sqrt;

public class LineSegment implements IShape {

    private Point startPoint;
    private Point endPoint;
    private int outlineColor;

    public LineSegment(Point startPoint, Point endPoint) {
        if (startPoint.equals(endPoint))
            throw new IllegalArgumentException("Start point and end point have the same coordinates");
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        outlineColor = 0;
    }

    public LineSegment(Point startPoint, Point endPoint, String outlineColor) {
        if (startPoint.equals(endPoint))
            throw new IllegalArgumentException("Start point and end point have the same coordinates");
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        try {
            this.outlineColor = Integer.parseInt(outlineColor, 16);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Incorrect value of color");
        }
    }

    @Override
    public double getArea() {
        return 0;
    }

    public double getLength() {
        return sqrt(square(endPoint.getX() - startPoint.getX()) + square(endPoint.getY() - startPoint.getY()));
    }

    @Override
    public double getPerimeter() {
        return 0;
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