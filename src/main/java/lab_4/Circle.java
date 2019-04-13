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

    public Circle(Point center, double radius, String outlineColor, String fillColor) {
        if (radius <= 0)
            throw new IllegalArgumentException("Radius should be positive");
        this.center = center;
        this.radius = radius;
        try {
            this.outlineColor = Integer.parseInt(outlineColor, 16);
            this.fillColor = Integer.parseInt(fillColor, 16);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Incorrect value of color");
        }
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