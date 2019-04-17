package Classes;

import java.util.ArrayList;
import Exception.*;
import Interfaces.IShape;
import Interfaces.IShapeFactory;

public class ShapeFactory implements IShapeFactory {

    private String shapeName;
    private ArrayList<String> shapeArguments;

    public ShapeFactory(String shapeName, ArrayList<String> shapeArguments) {
        this.shapeName = shapeName;
        this.shapeArguments = shapeArguments;
    }

    @Override
    public IShape makeShape() {
        IShape shape = null;
        switch (shapeName) {
            case "rectangle":
                shape = getRectangle();
                if (shape == null)
                    throw new IllegalRectangleArguments("Rectangle arguments exception");
                break;
            case "triangle":
                shape = getTriangle();
                if (shape == null)
                    throw new IllegalTriangleArguments("Triangle arguments exception");
                break;
            case "circle":
                shape = getCircle();
                if (shape == null)
                    throw new IllegalCircleArguments("Circle arguments exception");
                break;
            case "line":
                shape = getLineSegment();
                if (shape == null)
                    throw new IllegalLineArguments("Line arguments exception");
                break;
        }
        if (shape == null)
            throw new IllegalArgumentException("Invalid name of shape");
        return shape;
    }

    private Rectangle getRectangle() {
        if (shapeArguments.size() < 4 || shapeArguments.size() > 6)
            return null;
        try {
            Rectangle rectangle;
            Point point = new Point(Double.valueOf(shapeArguments.get(0)), Double.valueOf(shapeArguments.get(1)));
            double width = Double.valueOf(shapeArguments.get(2));
            double height = Double.valueOf(shapeArguments.get(3));
            if (shapeArguments.size() == 4)
                rectangle = new Rectangle(point, width, height);
            else if (shapeArguments.size() == 5)
                rectangle = new Rectangle(point, width, height, Integer.parseInt(shapeArguments.get(4), 16));
            else
                rectangle = new Rectangle(point, width, height, Integer.parseInt(shapeArguments.get(4), 16), Integer.parseInt(shapeArguments.get(5), 16));
            return rectangle;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private Triangle getTriangle() {
        if (shapeArguments.size() < 6 || shapeArguments.size() > 8)
            return null;
        try {
            Triangle triangle;
            Point vertex1 = new Point(Double.valueOf(shapeArguments.get(0)), Double.valueOf(shapeArguments.get(1)));
            Point vertex2 = new Point(Double.valueOf(shapeArguments.get(2)), Double.valueOf(shapeArguments.get(3)));
            Point vertex3 = new Point(Double.valueOf(shapeArguments.get(4)), Double.valueOf(shapeArguments.get(5)));
            if (shapeArguments.size() == 6)
                triangle = new Triangle(vertex1, vertex2, vertex3);
            else if (shapeArguments.size() == 7)
                triangle = new Triangle(vertex1, vertex2, vertex3, Integer.parseInt(shapeArguments.get(6), 16));
            else
                triangle = new Triangle(vertex1, vertex2, vertex3, Integer.parseInt(shapeArguments.get(6), 16), Integer.parseInt(shapeArguments.get(7), 16));
            return triangle;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private Circle getCircle() {
        if (shapeArguments.size() < 3 || shapeArguments.size() > 5)
            return null;
        try {
            Circle circle;
            Point point = new Point(Double.valueOf(shapeArguments.get(0)), Double.valueOf(shapeArguments.get(1)));
            double radius = Double.valueOf(shapeArguments.get(2));
            if (shapeArguments.size() == 3)
                circle = new Circle(point, radius);
            else if (shapeArguments.size() == 4)
                circle = new Circle(point, radius, Integer.parseInt(shapeArguments.get(3), 16));
            else
                circle = new Circle(point, radius, Integer.parseInt(shapeArguments.get(3), 16), Integer.parseInt(shapeArguments.get(4), 16));
            return circle;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private LineSegment getLineSegment() {
        if (shapeArguments.size() < 4 || shapeArguments.size() > 5)
            return null;
        try {
            LineSegment lineSegment;
            Point startPoint = new Point(Double.valueOf(shapeArguments.get(0)), Double.valueOf(shapeArguments.get(1)));
            Point endPoint = new Point(Double.valueOf(shapeArguments.get(2)), Double.valueOf(shapeArguments.get(3)));
            if (shapeArguments.size() == 4)
                lineSegment = new LineSegment(startPoint, endPoint);
            else
                lineSegment = new LineSegment(startPoint, endPoint, Integer.parseInt(shapeArguments.get(4), 16));
            return lineSegment;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
