import java.awt.*;

public class Circle implements ISolidShape {

    private Point center;
    private double radius;
    private int outlineColor;
    private int fillColor;

    public Circle(Point center, double radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Radius should be positive");
        this.center = center;
        this.radius = radius;
        outlineColor = Color.BLACK.getRGB();
        fillColor = Color.WHITE.getRGB();
    }

    public Circle(Point center, double radius, int outlineColor) {
        if (radius <= 0)
            throw new IllegalArgumentException("Radius should be positive");
        this.center = center;
        this.radius = radius;
        this.outlineColor = outlineColor;
        fillColor = Color.WHITE.getRGB();
    }

    public Circle(Point center, double radius, int outlineColor, int fillColor) {
        if (radius <= 0)
            throw new IllegalArgumentException("Radius should be positive");
        this.center = center;
        this.radius = radius;
        this.outlineColor = outlineColor;
        this.fillColor = fillColor;
    }

    @Override
    public int getFillColor() {
        return fillColor;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public int getOutlineColor() {
        return outlineColor;
    }

    public String toString() {
        return "circle " + center.getX() + " " + center.getY() + " " + radius + " "
                + Integer.toHexString(outlineColor) + " " + Integer.toHexString(fillColor);
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public double getLength() {
        return 2 * Math.PI * radius;
    }
}