import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import Exception.*;
public class Geometric {

    private ArrayList<IShape> shapes = new ArrayList<>();

    public String performCommand(String command) {
        ArrayList<String> commandElements = new ArrayList<>(Arrays.asList(command.split(" ")));
        if (commandElements.size() <= 1)
            return "Invalid string\n";
        String shapeName = commandElements.get(0);
        commandElements.remove(0);
        ShapeFactory shapeFactory = new ShapeFactory(shapeName, commandElements);
        return addShapeAndGetMessage(shapeFactory);
    }

    private String addShapeAndGetMessage(ShapeFactory shapeFactory) {
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

    private String getShapeInfo(IShape shape) {
        String outputString = "area: " + shape.getArea() + "\nperimeter: " + shape.getPerimeter()
                              + "\noutline color: " + Integer.toHexString(shape.getOutlineColor());
        try {
            outputString += "\nfill color: " + Integer.toHexString(((ISolidShape) shape).getFillColor());
        } catch (ClassCastException ignored) {}
        outputString += "\n" + shape.toString();
        return outputString;
    }

    private void drawShapes() {
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

    public void processingInput(Scanner inputScanner) {
        String inputString = inputScanner.nextLine();
        while (!inputString.equals("...")) {
            System.out.print(performCommand(inputString));
            inputString = inputScanner.nextLine();
        }
    }

    public static void main(String[] args) {
        Geometric geometric = new Geometric();
        Scanner inputScanner = new Scanner(System.in);
        geometric.processingInput(inputScanner);
        geometric.printShapeWithMaxArea();
        geometric.printShapeWithMinPerimeter();
        geometric.drawShapes();
    }
}
/*
rectangle 50 100 400 300 ff ff00
triangle 450 100 450 400 790 250 ff ffabf
circle 150 150 200 ff abfff
circle 175 175 150 123 bb33
line 450 80 790 230
line 450 420 790 270
line 450 80 450 100
line 450 420 450 400
line 790 230 790 270
*/