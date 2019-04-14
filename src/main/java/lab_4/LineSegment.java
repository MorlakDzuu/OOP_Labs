import java.awt.*;

import static java.lang.Math.sqrt;

public class LineSegment implements IShape, ICanvasDrawable {

    private Point startPoint;
    private Point endPoint;
    private int outlineColor;

    public LineSegment(Point startPoint, Point endPoint) {
        if (startPoint.equals(endPoint))
            throw new IllegalArgumentException("Start point and end point have the same coordinates");
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        outlineColor = Color.BLACK.getRGB();
    }

    public LineSegment(Point startPoint, Point endPoint, int outlineColor) {
        if (startPoint.equals(endPoint))
            throw new IllegalArgumentException("Start point and end point have the same coordinates");
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.outlineColor = outlineColor;
    }

    @Override
    public double getArea() {
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

    @Override
    public double getPerimeter() {
        return sqrt(square(endPoint.getX() - startPoint.getX()) + square(endPoint.getY() - startPoint.getY()));
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

    @Override
    public void draw(Canvas canvas) {
        canvas.drawLine(startPoint, endPoint, outlineColor);
    }
}