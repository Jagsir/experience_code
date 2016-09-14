package iteration;

import java.util.Queue;
import java.util.function.BiFunction;

class MyFolder<T, U> implements Folder<T, U>
{
    public U foldRecursive(U u, Queue<T> ts, BiFunction<T, U, U> function)
    {
        if(u == null || ts == null || function == null)
            throw new IllegalArgumentException();

        if (ts.isEmpty()) {
            return u;
        }

        // The recursive implementation will overflow the stack for
        // any data set of real size, your job is to implement a
        // non-recursive solution
        return foldRecursive(function.apply(ts.poll(), u), ts, function);
    }

    public U foldNonRecursive(U u, Queue<T> ts, BiFunction<T, U, U> function)
    {
        if(u == null || ts == null || function == null)
            throw new IllegalArgumentException();

        if (ts.isEmpty()) {
            return u;
        }

        // The recursive implementation will overflow the stack for
        // any data set of real size, your job is to implement a
        // non-recursive solution
        int queueSize = ts.size();
        for (int i = 0; i < queueSize; i++) {
            u = function.apply(ts.poll(), u);
        }
        return u;
    }
}
