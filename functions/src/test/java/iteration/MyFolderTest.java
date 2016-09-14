package iteration;

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
    //@formatter:off
    private int                                 sizeSmall         = 11000;
    private BiFunction<Integer, String, String> strFunction       = (x, y) -> y + "\n" + (x + 1);
    private String                              formattedString   = String.format("here is increment of %d : ", 1);
    private Queue<Integer>                      integerQueueSmall = new PriorityQueue<>();

    private int                                 sizeLarge         = 500000000;
    private BiFunction<Long, Long, Long>        intFunction       = (x, y) -> x + y;
    private Queue<Long>                         longQueueLarge    = new PriorityQueue<>(sizeLarge);
    private long                                result            = 0;
    //@formatter:on

    private
    void setUpSmall() throws Exception {
        for (int i = 0; i < sizeSmall; i++) {
            integerQueueSmall.add(i);
        }
    }

    private
    void setUpLarge() throws Exception {
        for (long i = 0; i < sizeLarge; i++) {
            longQueueLarge.add(i);
        }
    }

    @Test
    public
    void foldNR() throws Exception {
        setUpSmall();
        String strResult = new MyFolder<Integer, String>().foldNonRecursive(formattedString, integerQueueSmall, strFunction);
        System.err.println(strResult.substring(strResult.length() - 100));
    }

    @Test
    public
    void foldRecursive() throws Exception {
        setUpSmall();
        String strResult = new MyFolder<Integer, String>().foldRecursive(formattedString, integerQueueSmall, strFunction);
        System.err.println(strResult.substring(strResult.length() - 100));
    }

    @Test
    public
    void foldNRInt() throws Exception {
        setUpLarge();
        System.err.println(new MyFolder<Long, Long>().foldNonRecursive(result, longQueueLarge, intFunction));
    }

    @Test
    public
    void foldRecursiveInt() throws Exception {
        setUpLarge();
        System.err.println(new MyFolder<Long, Long>().foldRecursive(result, longQueueLarge, intFunction));
    }
}