import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

import static java.lang.StrictMath.sqrt;

public class PrimeNumbersGenerator {

    public static List<Integer> generatePrimeNumbers(int upperBound) {
        double upperBoundSqrt = sqrt(upperBound);
        List<Integer> primaryNumbers = new ArrayList<>();
        Boolean[] array = new Boolean[upperBound + 1];
        Arrays.fill(array, false);
        for (int i = 2; i <= upperBoundSqrt; i++) {
            if (!array[i]) {
                for (int j = i * i; j <= upperBound; j += i) {
                    array[j] = true;
                }
            }
        }
        for (int i = 5; i <= upperBound; i++) {
            if (!array[i]) {
                primaryNumbers.add(i);
            }
        }
        return primaryNumbers;
    }

    public static BitSet getPrimaryNumbers(int upperBound) {
        BitSet primaryNumbers = new BitSet();
        double upperBoundSqrt = sqrt(upperBound);
        for (int x = 1; x <= upperBoundSqrt; x++) {
            for (int y = 1, n; y <= upperBoundSqrt; y++) {
                n = 4*x*x + y*y;
                if (((n % 12 == 1) || (n % 12 == 5)) && (n <= upperBound)) primaryNumbers.flip(n);
                n -= x*x;
                if ((n % 12 == 7) && (n <= upperBound)) primaryNumbers.flip(n);
                if (x > y) {
                    n -= 2*y*y;
                    if ((n % 12 == 11) && (n <= upperBound)) primaryNumbers.flip(n);
                }
            }
        }
        for (int number: generatePrimeNumbers((int) upperBoundSqrt)) {
            number *= number;
            for (int i = number; i <= upperBound; i += number) {
                primaryNumbers.set(i, false);
            }
        }
        if (upperBound >= 2) primaryNumbers.set(2, true);
        if (upperBound >= 3) primaryNumbers.set(3, true);
        return primaryNumbers;
    }

    public static void main(String[] args) {
        String usageString = "Usage: java PrimeNumbersGenerator <number from the range 0..100000000>";
        if (args.length != 1) {
            System.out.println(usageString);
            System.exit(1);
        }
        int upperBound = 0;
        try {
            upperBound = Integer.valueOf(args[0]);
        } catch (NumberFormatException e) {
            System.out.println(usageString);
            System.exit(1);
        }
        if (upperBound > 100000000 || upperBound < 0) {
            System.out.println(usageString);
            System.exit(1);
        }
        BitSet primaryNumbers = getPrimaryNumbers(Integer.valueOf(args[0]));
        primaryNumbers.stream().forEach(elem -> System.out.print(elem + " "));
        System.out.println();
        System.exit(0);
    }
}