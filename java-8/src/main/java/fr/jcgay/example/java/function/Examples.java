package fr.jcgay.example.java.function;

import java.util.function.Function;

public class Examples {

    public static void main(String[] args) {
        Function<Integer, String> toString = n -> String.valueOf(n);
        Function<String, Integer> toInteger = s -> Integer.valueOf(s);

        assert "4".equals(toString.apply(4));
        assert toInteger.apply("4") == 4;

        assert "4".equals(toString.compose(toInteger).apply("4"));
        assert toString.andThen(toInteger).apply(4) == 4;
    }

}
