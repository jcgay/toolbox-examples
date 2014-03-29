package fr.jcgay.example.java.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class Examples {

    public static void main(String[] args) {

        List<Integer> numbers = asList(10, 1, 1000, 100);
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        });

        Collections.sort(numbers, (a, b) -> a.compareTo(b));
    }
}
