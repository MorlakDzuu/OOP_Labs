import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TransformArrayTest {

    TransformArrayImplementation transformArray;

    @Before
    public void init() {
        transformArray = new TransformArrayImplementation();
    }

    @Test
    public void readArray() {
        ArrayList<Double> actual1 = transformArray.readArray("2.345 24.54 6.16");
        ArrayList<Double> actual2 = transformArray.readArray("");
        ArrayList<Double> actual3 = transformArray.readArray("hello");
        ArrayList<Double> actual4 = transformArray.readArray("-1.543 -3.456 1.3");

        ArrayList<Double> expected1 = new ArrayList<>(Arrays.asList(2.345, 24.54, 6.16));
        ArrayList<Double> expected2 = new ArrayList<>();
        ArrayList<Double> expected3 = null;
        ArrayList<Double> expected4 = new ArrayList<>(Arrays.asList(-1.543, -3.456, 1.3));

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @Test
    public void processArray() {
        ArrayList<Double> inputArray1 = new ArrayList<>(Arrays.asList(1.5, 0.2, 5.43));
        ArrayList<Double> actual1 = transformArray.processArray(inputArray1);
        ArrayList<Double> expected1 = new ArrayList<>(Arrays.asList(40.725, 5.43, 147.424));

        assertEquals(expected1, actual1);
    }

    @Test
    public  void  sortArray() {
        ArrayList<Double> inputArray1 = new ArrayList<>(Arrays.asList(1.5, 0.2, 5.43));
        ArrayList<Double> actual1 = transformArray.sortArray(inputArray1);
        ArrayList<Double> expected1 = new ArrayList<>(Arrays.asList(0.2, 1.5, 5.43));

        ArrayList<Double> inputArray2 = new ArrayList<>(Arrays.asList(1.5, 0.2, -5.43, 0.0, 5.0));
        ArrayList<Double> actual2 = transformArray.sortArray(inputArray2);
        ArrayList<Double> expected2 = new ArrayList<>(Arrays.asList(-5.43, 0.0, 0.2, 1.5, 5.0));

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }
}