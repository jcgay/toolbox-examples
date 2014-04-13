package fr.jcgay.example.java.function;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Examples {

    public static void main(String[] args) {
        Function<Integer, String> toString = n -> String.valueOf(n);
        Function<String, Integer> toInteger = s -> Integer.valueOf(s);

        assert "4".equals(toString.apply(4));
        assert toInteger.apply("4") == 4;

        assert "4".equals(toString.compose(toInteger).apply("4"));
        assert toString.andThen(toInteger).apply(4) == 4;

        BiFunction<Integer, String, String> concat = (Integer i, String s) -> s + ": " + i;
        assert "un: 1".equals(concat.apply(1, "un"));

        assert UnaryOperator.identity().apply("un").equals("un");

        BinaryOperator<String> concatString = (s1, s2) -> s1.concat(": ").concat(s2);
        assert "un: 1".equals(concatString.apply("un", "1"));
    }

}
