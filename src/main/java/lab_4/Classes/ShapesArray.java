package Classes;

import Exception.IllegalCircleArguments;
import Exception.IllegalLineArguments;
import Exception.IllegalRectangleArguments;
import Exception.IllegalTriangleArguments;
import Interfaces.ICanvasDrawable;
import Interfaces.IShape;
import Interfaces.ISolidShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class ShapesArray {
    private ArrayList<IShape> shapes = new ArrayList<>();

    public String addShapeAndGetMessage(ShapeFactory shapeFactory) {
        try {
            shapes.add(shapeFactory.makeShape());
            return "";
        } catch (IllegalRectangleArguments e) {
            return "Usage: rectangle <left vertex coordinate x> <left vertex coordinate y> <width> <height> <outline color in hex string> <fill color in hex string>\n";
        } catch (IllegalTriangleArguments e) {
            return "Usage: triangle <1 vertex coordinate x> <1 vertex coordinate y> <2 vertex coordinate x> <2 vertex coordinate y> <3 vertex coordinate x> <3 vertex coordinate y> " +
                    "<outline color in hex string> <fill color in hex string>\n";
        } catch (IllegalCircleArguments e) {
            return "Usage: circle <center vertex coordinate x> <center vertex coordinate y> <radius> <outline color in hex string> <fill color in hex string>\n";
        } catch (IllegalLineArguments e) {
            return "Usage: line <start point coordinate x> <start point coordinate y> <end point coordinate x> <end point coordinate y> <outline color in hex string>\n";
        } catch (IllegalArgumentException e) {
            return "There is no such shape's name\n";
        }
    }

    public IShape getMaxAreaShape() {
        return shapes.stream().max(Comparator.comparingDouble(IShape::getArea)).get();
    }

    public IShape getMinPerimeterShape() {
        return shapes.stream().min(Comparator.comparingDouble(IShape::getPerimeter)).get();
    }

    public void printShapeWithMaxArea() {
        if (shapes.size() > 0) {
            IShape shapeWithMaxArea = getMaxAreaShape();
            System.out.println("Max area\n" + getShapeInfo(shapeWithMaxArea) + "\n");
        }
    }

    public void printShapeWithMinPerimeter() {
        if (shapes.size() > 0) {
            IShape shapeWithMinPerimeter = getMinPerimeterShape();
            System.out.println("Min perimeter\n" + getShapeInfo(shapeWithMinPerimeter));
        }
    }

    public String getShapeInfo(IShape shape) {
        String outputString = "area: " + shape.getArea() + "\nperimeter: " + shape.getPerimeter()
                + "\noutline color: " + Integer.toHexString(shape.getOutlineColor());
        if (shape instanceof ISolidShape)
            outputString += "\nfill color: " + Integer.toHexString(((ISolidShape) shape).getFillColor());
        outputString += "\n" + shape.toString();
        return outputString;
    }

    public void drawShapes() {
        if (shapes.size() == 0)
            return;
        JFrame jFrame = new JFrame("Frame"){
            public void paint(Graphics graphics) {
                super.paint(graphics);
                Canvas canvas = new Canvas(graphics);
                for (IShape shape: shapes) {
                    ((ICanvasDrawable) shape).draw(canvas);
                }
            }
        };
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800 , 600);
        jFrame.setVisible(true);
    }
}
