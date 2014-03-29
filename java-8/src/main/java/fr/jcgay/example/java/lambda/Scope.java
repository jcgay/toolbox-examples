package fr.jcgay.example.java.lambda;

import java.util.function.Function;

public class Scope {

    public static void main(String[] args) {

        Integer n = 4;
        Function<Integer, Integer> modulo = (Integer a) -> a % n;

        assert modulo.apply(8) == 0;
    }
}
