import java.awt.*;

public class Rectangle implements ISolidShape {

    private Point startVertex;
    private double width;
    private double height;
    private int outlineColor;
    private int fillColor;

    public Rectangle(Point startVertex, double width, double height) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Width and height should be positive");
        this.startVertex = startVertex;
        this.width = width;
        this.height = height;
        outlineColor = Color.BLACK.getRGB();
        fillColor = Color.WHITE.getRGB();
    }

    public Rectangle(Point startVertex, double width, double height, int outlineColor) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Width and height should be positive");
        this.startVertex = startVertex;
        this.width = width;
        this.height = height;
        this.outlineColor = outlineColor;
        fillColor = Color.WHITE.getRGB();
    }

    public Rectangle(Point startVertex, double width, double height, int outlineColor, int fillColor) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Width and height should be positive");
        this.startVertex = startVertex;
        this.width = width;
        this.height = height;
        this.outlineColor = outlineColor;
        this.fillColor = fillColor;
    }

    @Override
    public int getFillColor() {
        return fillColor;
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return 2*(width + height);
    }

    @Override
    public int getOutlineColor() {
        return outlineColor;
    }

    @Override
    public String toString() {
        return  "rectangle " + startVertex.getX() + " " + startVertex.getY() + " " +
                width + " " + height + " " + Integer.toHexString(outlineColor) + " " +
                Integer.toHexString(fillColor);
    }

    public Point getLeftTop() {
        return startVertex;
    }

    public Point getRightBottom() {
        return new Point(startVertex.getX() + width, startVertex.getY() - height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}