import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Test cases:
 * Email example
 * All values in 2D array are the same
 * Empty array passed
 * When array holds "a lot" of values
 * When there are negative values
 */
public class FlattenArrayTest {
    private final FlattenArray testExample = new FlattenArray();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private final int emailArray[][] = {{1}, {2}, {3}, {4, 5}, {6}, {7, 8}, {9}};
    private final int allSameArray[][] = {{1}, {1}, {1}, {1, 1}, {1}, {1, 1}, {1}};
    private final int emptyArray[][] = null;
    private final int largeArray[][] = {{1, 200, 4, 5}, {2, 9,0}, {3, 1, 99}, {4, 100, 5}, {6, 80}, {90,7, 8, 100}, {9,5000}};
    private final int negativeArray[][] = {{1, 200, 4, 5}, {-200, 9,0}, {3, 1, 99}, {4, 100, -1}, {6, 80}, {90,7}, {9,5000}};
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void emailExample_shouldReturnFlattened() throws Exception {
        int [] expected = {1,2,3,4,5,6,7,8,9};
        assertArrayEquals(expected, testExample.flattenArray(emailArray));
    }
    @Test
    public void emailExample_shouldReportHighest9Lowest1() throws Exception{
        int[][] array = {{1}, {2}, {3}, {4, 5}, {6}, {7, 8}, {9}};
        testExample.flattenArray(emailArray);
        assertEquals("Highest Value: 9\nLowest Value: 1\n", outContent.toString());
    }
    @Test
    public void allSameValues_shouldReturnFlattened() throws Exception{
        int [] expected = {1,1,1,1,1,1,1,1,1};
        assertArrayEquals(expected, testExample.flattenArray(allSameArray));
    }
    @Test
    public void allSameValues_shouldReportHighest1Lowest1() throws Exception{
        testExample.flattenArray(allSameArray);
        assertEquals("Highest Value: 1\nLowest Value: 1\n", outContent.toString());
    }
    @Test(expected = NullPointerException.class)
    public void emptyArray_shouldThrowException() throws Exception{
        testExample.flattenArray(emptyArray);
    }
    @Test(expected = NullPointerException.class)
    public void emptyArray_shouldReportHighestNothingLowestNothing() throws Exception{
        testExample.flattenArray(emptyArray);
    }
    @Test
    public void largeExample_shouldReturnFlattened() throws Exception {
        int [] expected = {1, 200, 4, 5, 2, 9,0, 3, 1, 99, 4, 100, 5, 6, 80, 90,7, 8, 100, 9,5000};
        assertArrayEquals(expected, testExample.flattenArray(largeArray));
    }
    @Test
    public void largeExample_shouldReportHighest5000Lowest0() throws Exception{
        testExample.flattenArray(largeArray);
        assertEquals("Highest Value: 5000\nLowest Value: 0\n", outContent.toString());
    }
    @Test
    public void negativeExample_shouldReturnFlattened() throws Exception {
        int [] expected = {1, 200, 4, 5, -200, 9,0, 3, 1, 99, 4, 100, -1, 6, 80, 90,7, 9,5000};
        assertArrayEquals(expected, testExample.flattenArray(negativeArray));
    }
    @Test
    public void negativeExample_shouldReportHighest5000LowestNeg1() throws Exception{
        testExample.flattenArray(negativeArray);
        assertEquals("Highest Value: 5000\nLowest Value: -200\n", outContent.toString());
    }
}