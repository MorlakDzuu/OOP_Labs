import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.StrictMath.sqrt;

public class PrimeNumbersGenerator {

    private static int counter = 0;

    public static List<Integer> generatePrimeNumbers(int upperBound) {
        int CACHE = 30000;
        double upperBoundSqrt = sqrt(upperBound);
        List<Integer> primaryNumbers = new ArrayList<>();
        Boolean[] array = new Boolean[upperBound + 1];
        Arrays.fill(array, false);
        for (int i = 2; i <= upperBoundSqrt; i++) {
            if (!array[i]) {
                for (int j = i * i; j <= upperBound; j+=i) {
                    array[j] = true;
                }
            }
        }
        for (int i = 2; i <= upperBound; i++) {
            if (!array[i]) {
                primaryNumbers.add(i);
            }
       }
        return primaryNumbers;
    }

    public static void main(String[] args) {
        List<Integer> primaryNumbers = generatePrimeNumbers(10000000);
        System.out.println(primaryNumbers.size());
    }
}