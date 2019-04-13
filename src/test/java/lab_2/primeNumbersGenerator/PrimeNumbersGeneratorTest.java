import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.assertEquals;

public class PrimeNumbersGeneratorTest {

    PrimeNumbersGenerator primeNumbersGenerator;

    BitSet primeNumbersSet;

    @Before
    public void init() {
        primeNumbersGenerator = new PrimeNumbersGenerator();
        primeNumbersSet = new BitSet();
    }

    @After
    public void remove() {
        primeNumbersSet.clear();
    }

    @Test
    public void testWorking() {
        primeNumbersSet.set(2);
        primeNumbersSet.set(3);
        primeNumbersSet.set(5);
        primeNumbersSet.set(7);
        primeNumbersSet.set(11);
        primeNumbersSet.set(13);
        primeNumbersSet.set(17);
        primeNumbersSet.set(19);
        assertEquals(primeNumbersSet, primeNumbersGenerator.getPrimaryNumbers(20));
    }


    @Test
    public void testBottomBound() {
        assertEquals(primeNumbersSet, primeNumbersGenerator.getPrimaryNumbers(0));
        primeNumbersSet.set(2);
        assertEquals(primeNumbersSet, primeNumbersGenerator.getPrimaryNumbers(2));
        primeNumbersSet.set(3);
        assertEquals(primeNumbersSet, primeNumbersGenerator.getPrimaryNumbers(3));
    }

    @Test
    public void testUpperBound() {
        assertEquals(5761455, primeNumbersGenerator.getPrimaryNumbers(100000000).stream().count());
    }
}