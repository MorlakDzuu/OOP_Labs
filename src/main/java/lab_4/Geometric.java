import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Geometric {

    private ArrayList<IShape> shapes = new ArrayList<>();

    public String performCommand(String command) {
        ArrayList<String> commandElements = new ArrayList<>(Arrays.asList(command.split(" ")));
        if (commandElements.size() <= 1)
            return "Invalid string\n";
        String shape = commandElements.get(0);
        commandElements.remove(0);
        switch (shape) {
            case "rectangle":
                Rectangle rectangle = getRectangle(commandElements);
                if (rectangle != null)
                    shapes.add(rectangle);
                else
                    return "Usage: rectangle <left vertex coordinate x> <left vertex coordinate y> <width> <height> <outline color in hex string> <fill color in hex string>\n";
                break;
            case "triangle":
                Triangle triangle = getTriangle(commandElements);
                if (triangle != null)
                    shapes.add(triangle);
                else
                    return "Usage: triangle <1 vertex coordinate x> <1 vertex coordinate y> <2 vertex coordinate x> <2 vertex coordinate y> <3 vertex coordinate x> <3 vertex coordinate y> " +
                            "<outline color in hex string> <fill color in hex string>\n";
                break;
            case "circle":
                Circle circle = getCircle(commandElements);
                if (circle != null)
                    shapes.add(circle);
                else
                    return "Usage: circle <center vertex coordinate x> <center vertex coordinate y> <radius> <outline color in hex string> <fill color in hex string>\n";
                break;
            case "line":
                LineSegment lineSegment = getLineSegment(commandElements);
                if (lineSegment != null)
                    shapes.add(lineSegment);
                else
                    return "Usage: line <start point coordinate x> <start point coordinate y> <end point coordinate x> <end point coordinate y> <outline color in hex string>\n";
                break;
        }
        return "";
    }

    public Rectangle getRectangle(ArrayList<String> arguments) {
        if (arguments.size() < 4 || arguments.size() > 6)
            return null;
        try {
            Rectangle rectangle;
            Point point = new Point(Double.valueOf(arguments.get(0)), Double.valueOf(arguments.get(1)));
            double width = Double.valueOf(arguments.get(2));
            double height = Double.valueOf(arguments.get(3));
            if (arguments.size() == 4)
                rectangle = new Rectangle(point, width, height);
            else if (arguments.size() == 5)
                rectangle = new Rectangle(point, width, height, Integer.parseInt(arguments.get(4), 16));
            else
                rectangle = new Rectangle(point, width, height, Integer.parseInt(arguments.get(4), 16), Integer.parseInt(arguments.get(5), 16));
            return rectangle;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public Triangle getTriangle(ArrayList<String> arguments) {
        if (arguments.size() < 6 || arguments.size() > 8)
            return null;
        try {
            Triangle triangle;
            Point vertex1 = new Point(Double.valueOf(arguments.get(0)), Double.valueOf(arguments.get(1)));
            Point vertex2 = new Point(Double.valueOf(arguments.get(2)), Double.valueOf(arguments.get(3)));
            Point vertex3 = new Point(Double.valueOf(arguments.get(4)), Double.valueOf(arguments.get(5)));
            if (arguments.size() == 6)
                triangle = new Triangle(vertex1, vertex2, vertex3);
            else if (arguments.size() == 7)
                triangle = new Triangle(vertex1, vertex2, vertex3, Integer.parseInt(arguments.get(6), 16));
            else
                triangle = new Triangle(vertex1, vertex2, vertex3, Integer.parseInt(arguments.get(6), 16), Integer.parseInt(arguments.get(7), 16));
            return triangle;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public Circle getCircle(ArrayList<String> arguments) {
        if (arguments.size() < 3 || arguments.size() > 5)
            return null;
        try {
            Circle circle;
            Point point = new Point(Double.valueOf(arguments.get(0)), Double.valueOf(arguments.get(1)));
            double radius = Double.valueOf(arguments.get(2));
            if (arguments.size() == 3)
                circle = new Circle(point, radius);
            else if (arguments.size() == 4)
                circle = new Circle(point, radius, Integer.parseInt(arguments.get(3), 16));
            else
                circle = new Circle(point, radius, Integer.parseInt(arguments.get(3), 16), Integer.parseInt(arguments.get(4), 16));
            return circle;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public LineSegment getLineSegment(ArrayList<String> arguments) {
        if (arguments.size() < 4 || arguments.size() > 5)
            return null;
        try {
            LineSegment lineSegment;
            Point startPoint = new Point(Double.valueOf(arguments.get(0)), Double.valueOf(arguments.get(1)));
            Point endPoint = new Point(Double.valueOf(arguments.get(2)), Double.valueOf(arguments.get(3)));
            if (arguments.size() == 4)
                lineSegment = new LineSegment(startPoint, endPoint);
            else
                lineSegment = new LineSegment(startPoint, endPoint, Integer.parseInt(arguments.get(4), 16));
            return lineSegment;
        } catch (IllegalArgumentException e) {
            return null;
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

    public static void main(String[] args) {
        Geometric geometric = new Geometric();
        Scanner inputScanner = new Scanner(System.in);
        String inputString = inputScanner.nextLine();
        while (!inputString.equals("...")) {
            System.out.print(geometric.performCommand(inputString));
            inputString = inputScanner.nextLine();
        }
        IShape shapeWithMaxArea = geometric.getMaxAreaShape();
        IShape shapeWithMinPerimeter = geometric.getMinPerimeterShape();
        System.out.println("Max area\n" + geometric.getShapeInfo(shapeWithMaxArea) + "\n");
        System.out.println("Min perimeter\n" + geometric.getShapeInfo(shapeWithMinPerimeter));
    }
}