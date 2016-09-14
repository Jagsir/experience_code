package iteration;

import java.util.Queue;
import java.util.function.BiFunction;

interface Folder<T, U>
{
    U foldRecursive(U u, Queue<T> list, BiFunction<T,U,U> function);
    U foldNonRecursive(U u, Queue<T> ts, BiFunction<T, U, U> function);
}

