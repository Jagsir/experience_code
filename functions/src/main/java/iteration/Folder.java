package iteration;

import java.util.Queue;
import java.util.function.BiFunction;

interface Folder<T, U>
{
    U fold(U u, Queue<T> list, BiFunction<T,U,U> function);
}
