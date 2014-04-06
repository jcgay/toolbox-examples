package fr.jcgay.example.java.stream;

import java.util.stream.IntStream;

public class Sum {

    public static void main(String[] args) {

        assert IntStream.rangeClosed(1, 10).sum() == 55;
    }
}
