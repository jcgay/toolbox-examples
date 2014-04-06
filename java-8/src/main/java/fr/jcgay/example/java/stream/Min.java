package fr.jcgay.example.java.stream;

import java.util.stream.IntStream;

public class Min {

    public static void main(String[] args) {

        assert IntStream.rangeClosed(1, 10)
                .min()
                .getAsInt()
            == 1;

        assert IntStream.rangeClosed(1, 10)
                .max()
                .getAsInt()
            == 10;
    }
}
