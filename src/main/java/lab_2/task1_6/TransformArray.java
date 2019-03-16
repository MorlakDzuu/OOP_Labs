import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TransformArray {

    public static ArrayList<Double> readArray(String inputString) {
        Scanner scanner = new Scanner(inputString);
        scanner.useLocale(Locale.US);
        ArrayList<Double> doubles = new ArrayList<>();
        while (scanner.hasNextDouble()) {
            doubles.add(scanner.nextDouble());
        }
        if (scanner.hasNext()) {
            return null;
        }
        return doubles;
    }

    public static ArrayList<Double> transformArray(String[] args) {
        String inputString = "";
        for (String elem: args) {
            inputString += elem + " ";
        }
        ArrayList<Double> doubles = readArray(inputString);
        if (doubles == null)
            return null;
        doubles = TransformArrayImplementation.processArray(doubles);
        doubles = TransformArrayImplementation.sortArray(doubles);
        return doubles;
    }

    public static void main(String[] args) {
        if (args.length == 0 || transformArray(args) == null) {
            System.out.println("Usage: java TransformArray <list of doubles separated by a space>");
            System.exit(1);
        }
        ArrayList<Double> doubles = transformArray(args);
        doubles.stream().forEach(elem -> System.out.print(elem + " "));
        System.out.println();
        System.exit(0);
    }
}
