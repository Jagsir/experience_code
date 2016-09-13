package iteration;

import static org.junit.Assert.*;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.BiFunction;

import org.junit.Before;
import org.junit.Test;

/**
 * Created: 14/09/2016 7:56 AM.
 */
public
class MyFolderTest {
    private int size = 300000;
    private BiFunction<Integer, String, String> function        = (x, y) -> y + "\n" + (x + 1);
    private String                              formattedString = String.format("here is increment of %d : ", 1);
    private Queue<Integer>                      integerQueue    = new PriorityQueue<>();

    @Before
    public
    void setUp() throws Exception {
        for (int i = 0; i < size; i++) {
            integerQueue.add(i);
        }
    }

    @Test
    public
    void fold() throws Exception {
        System.err.println( new MyFolder<Integer, String>().fold(formattedString, integerQueue, function));
    }

    @Test
    public
    void foldRecursive() throws Exception {
        System.err.println(new MyFolder<Integer, String>().foldRecursive(formattedString, integerQueue, function));
    }
}