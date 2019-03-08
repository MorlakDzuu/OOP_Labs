import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class TransformArrayImplementation {

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

    public static ArrayList<Double> processArray(ArrayList<Double> doubles) {
        double max = Collections.max(doubles);
        double min = Collections.min(doubles);
        ArrayList<Double> transformedDoubles = new ArrayList<>();
        for (double current: doubles) {
            current = current * max / min;
            transformedDoubles.add((double)Math.round(current * 1000) / 1000);
        }
        return transformedDoubles;
    }

    public static ArrayList<Double> sortArray(ArrayList<Double> doubles) {
        ArrayList<Double> sortedArray = new ArrayList<>();
        doubles.stream().sorted().forEach(sortedArray::add);
        return sortedArray;
    }
}
