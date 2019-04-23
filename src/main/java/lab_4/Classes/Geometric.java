package Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Geometric {

    private ShapesArray shapesArray = new ShapesArray();

    public String createShape(String command) {
        ArrayList<String> commandElements = new ArrayList<>(Arrays.asList(command.split(" ")));
        if (commandElements.size() <= 1)
            return "Invalid string\n";
        String shapeName = commandElements.get(0);
        commandElements.remove(0);
        ShapeFactory shapeFactory = new ShapeFactory(shapeName, commandElements);
        return shapesArray.addShapeAndGetMessage(shapeFactory);
    }


    public void processInput(Scanner inputScanner) {
        String inputString = inputScanner.nextLine();
        while (!inputString.equals("...")) {
            System.out.print(createShape(inputString));
            inputString = inputScanner.nextLine();
        }
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Geometric geometric = new Geometric();
        geometric.processInput(inputScanner);
        geometric.shapesArray.printShapeWithMaxArea();
        geometric.shapesArray.printShapeWithMinPerimeter();
        geometric.shapesArray.drawShapes();
    }
}
/*
rectangle 50 100 400 300 ff ff00
triangle 450 100 450 400 790 250 ff ffabf
circle 150 150 100 ff abfff
circle 175 175 75 123 bb33
line 450 80 790 230
line 450 420 790 270
line 450 80 450 100
line 450 420 450 400
line 790 230 790 270
*/