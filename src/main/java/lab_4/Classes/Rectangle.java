package Classes;

import Interfaces.ICanvas;
import Interfaces.ICanvasDrawable;
import Interfaces.ISolidShape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Rectangle implements ISolidShape, ICanvasDrawable {

    private Point startVertex;
    private Point rightBottomVertex;
    private Point rightTopPoint;
    private Point leftBottomPoint;
    private double width;
    private double height;
    private int outlineColor;
    private int fillColor;

    public Rectangle(Point startVertex, double width, double height) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Width and height should be positive");
        this.startVertex = startVertex;
        this.rightBottomVertex = new Point(startVertex.getX() + width, startVertex.getY() + height);
        this.rightTopPoint = new Point(startVertex.getX() + width, startVertex.getY());
        this.leftBottomPoint = new Point(startVertex.getX(), startVertex.getY() + height);
        this.width = width;
        this.height = height;
        outlineColor = Color.BLACK.getRGB();
        fillColor = Color.WHITE.getRGB();
    }

    public Rectangle(Point startVertex, double width, double height, int outlineColor) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Width and height should be positive");
        this.rightBottomVertex = new Point(startVertex.getX() + width, startVertex.getY() + height);
        this.rightTopPoint = new Point(startVertex.getX() + width, startVertex.getY());
        this.leftBottomPoint = new Point(startVertex.getX(), startVertex.getY() + height);
        this.startVertex = startVertex;
        this.width = width;
        this.height = height;
        this.outlineColor = outlineColor;
        fillColor = Color.WHITE.getRGB();
    }

    public Rectangle(Point startVertex, double width, double height, int outlineColor, int fillColor) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Width and height should be positive");
        this.rightBottomVertex = new Point(startVertex.getX() + width, startVertex.getY() + height);
        this.rightTopPoint = new Point(startVertex.getX() + width, startVertex.getY());
        this.leftBottomPoint = new Point(startVertex.getX(), startVertex.getY() + height);
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
        return rightBottomVertex;
    }

    public Point getRightTopPoint() {
        return rightTopPoint;
    }

    public Point getLeftBottomPoint() {
        return leftBottomPoint;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void draw(ICanvas canvas) {
        canvas.drawLine(startVertex, rightTopPoint, outlineColor);
        canvas.drawLine(rightTopPoint, getRightBottom(), outlineColor);
        canvas.drawLine(getRightBottom(), leftBottomPoint, outlineColor);
        canvas.drawLine(leftBottomPoint, startVertex, outlineColor);
        canvas.fillPolygon(new ArrayList<>(Arrays.asList(startVertex, rightTopPoint, getRightBottom(), leftBottomPoint)), fillColor);
    }
}