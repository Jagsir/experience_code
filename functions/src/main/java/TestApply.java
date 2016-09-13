import java.util.function.BiFunction;
import java.util.function.Function;

class TestApply {
    void apply() {

        Function<Integer, Integer>          add1    = x -> x + 1;
        Function<String, String>            concat1 = x -> x + 1;
        BiFunction<String, Integer, String> concat2 = (x, y) -> x + (1 + y);

        Integer two = add1.apply(1); //yields 2
        String answer = concat1.apply("0 + 1 = "); //yields "0 + 1 = 1"
        String answer2 = concat2.apply(String.format("here is increment of %d : ", two), two);

        System.err.println("add1" + add1 + "\nanswer:" + two);
        System.err.println("concat1" + concat1 + "\nanswer:" + answer);
        System.err.println("concat2" + concat2 + "\nanswer2:" + answer2);
    }
}
