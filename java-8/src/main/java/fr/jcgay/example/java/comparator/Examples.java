package fr.jcgay.example.java.comparator;

import java.util.Comparator;

public class Examples {

    public static void main(String[] args) {

        Comparator<Integer> ascending = (a, b) -> a.compareTo(b);

        assert ascending.compare(10, 1) > 0;
        assert ascending.reversed().compare(10, 1) < 0;
    }
}
