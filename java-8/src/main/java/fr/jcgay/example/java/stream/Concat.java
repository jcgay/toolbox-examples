package fr.jcgay.example.java.stream;

import java.util.stream.IntStream;

public class Concat {

    public static void main(String[] args) {

    IntStream.concat(
            IntStream.range(0, 4),
            IntStream.range(4, 6)
    ).forEach(System.out::print);
    }
}
