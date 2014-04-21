package fr.jcgay.example.java.overload;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class A {

    public void method(BiFunction<Boolean, Boolean, Boolean> function) {
        System.out.println("bifunction");
    }

    public void method(BinaryOperator<Boolean> function) {
        System.out.println("binaryoperator");
    }

        public void anotherMethod(Predicate<String> predicate) {
            System.out.println("predicate");
        }

        public void anotherMethod(StringPredicate predicate) {
            System.out.println("string predicate");
        }
}
