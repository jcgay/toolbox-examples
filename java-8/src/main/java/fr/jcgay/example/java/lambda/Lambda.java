package fr.jcgay.example.java.lambda;

import java.util.function.Function;

public class Lambda {

    private static int staticNumber;
    private int number;

    public void write() {
        Function<Integer, Integer> function = (Integer a) -> staticNumber = a;
        Function<Integer, Integer> function2 = (Integer a) -> number = a;
    }
}
