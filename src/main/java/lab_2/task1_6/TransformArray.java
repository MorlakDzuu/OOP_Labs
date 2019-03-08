import java.util.ArrayList;

public class TransformArray {

    public static ArrayList<Double> transformArray(String[] args) {
        String inputString = "";
        for (String elem: args) {
            inputString += elem + " ";
        }
        TransformArrayImplementation transformArrayImplementation = new TransformArrayImplementation();
        ArrayList<Double> doubles = transformArrayImplementation.readArray(inputString);
        if (doubles == null)
            return null;
        doubles = transformArrayImplementation.processArray(doubles);
        doubles = transformArrayImplementation.sortArray(doubles);
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
