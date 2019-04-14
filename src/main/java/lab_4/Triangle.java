import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Triangle implements ISolidShape, ICanvasDrawable {

    private Point vertex1;
    private Point vertex2;
    private Point vertex3;
    private int outlineColor;
    private int fillColor;

    public Triangle(Point vertex1, Point vertex2, Point vertex3) {
        if (vertex1.equals(vertex2) || vertex1.equals(vertex3) || vertex2.equals(vertex3))
            throw new IllegalArgumentException("Vertexes should not have the same coordinates");
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        outlineColor = Color.BLACK.getRGB();
        fillColor = Color.WHITE.getRGB();
    }

    public Triangle(Point vertex1, Point vertex2, Point vertex3, int outlineColor) {
        if (vertex1.equals(vertex2) || vertex1.equals(vertex3) || vertex2.equals(vertex3))
            throw new IllegalArgumentException("Vertexes should not have the same coordinates");
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        this.outlineColor = outlineColor;
        fillColor = Color.WHITE.getRGB();
    }

    public Triangle(Point vertex1, Point vertex2, Point vertex3, int outlineColor, int fillColor) {
        if (vertex1.equals(vertex2) || vertex1.equals(vertex3) || vertex2.equals(vertex3))
            throw new IllegalArgumentException("Vertexes should not have the same coordinates");
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        this.outlineColor = outlineColor;
        this.fillColor = fillColor;
    }

    public Point getVertex1() {
        return vertex1;
    }

    public Point getVertex2() {
        return vertex2;
    }

    public Point getVertex3() {
        return vertex3;
    }

    @Override
    public String toString() {
        return  "triangle " + vertex1.getX() + " " + vertex1.getY() + " " +
                vertex2.getX() + " " + vertex2.getY() + " " +
                vertex3.getX() + " " + vertex3.getY() + " " +
                Integer.toHexString(outlineColor) + " " + Integer.toHexString(fillColor);
    }

    @Override
    public int getFillColor() {
        return fillColor;
    }

    @Override
    public double getArea() {
        double[][] matrix = new double[2][2];
        matrix[0][0] = vertex1.getX() - vertex3.getX();
        matrix[0][1] = vertex1.getY() - vertex3.getY();
        matrix[1][0] = vertex2.getX() - vertex3.getX();
        matrix[1][1] = vertex2.getY() - vertex3.getY();
        double area = 0.5*(matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0]);
        if (area < 0)
            area = -area;
        return area;
    }

    @Override
    public double getPerimeter() {
        LineSegment lineSegment1 = new LineSegment(vertex1, vertex2);
        LineSegment lineSegment2 = new LineSegment(vertex2, vertex3);
        LineSegment lineSegment3 = new LineSegment(vertex3, vertex1);
        return lineSegment1.getPerimeter() + lineSegment2.getPerimeter() + lineSegment3.getPerimeter();
    }

    @Override
    public int getOutlineColor() {
        return outlineColor;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawLine(vertex1, vertex2, outlineColor);
        canvas.drawLine(vertex2, vertex3, outlineColor);
        canvas.drawLine(vertex3, vertex1, outlineColor);
        canvas.fillPolygon(new ArrayList<>(Arrays.asList(vertex1, vertex2, vertex3)), 3);
    }
}