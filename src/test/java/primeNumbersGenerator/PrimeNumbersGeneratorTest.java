import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class PrimeNumbersGeneratorTest {

    PrimeNumbersGenerator primeNumbersGenerator;

    @Before
    public void init() {
        primeNumbersGenerator = new PrimeNumbersGenerator();
    }

    @Test
    public void generatePrimeNumbers() {
        Set<Integer> primeNumbersSet = new TreeSet<>();
        primeNumbersSet.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        assertEquals(primeNumbersSet, primeNumbersGenerator.generatePrimeNumbers(20));
    }
}