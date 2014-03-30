package fr.jcgay.example.java.consumer;

import java.util.function.Consumer;

public class Examples {

    public static void main(String[] args) {

        Consumer<String> print = s -> System.out.println(s);
        Consumer<String> hello = s -> System.out.printf("Hello %s !", s);

        print.accept("something"); // something
        print.andThen(hello).accept("JC"); // JC Hello JC !
    }
}
