package fr.jcgay.example.java.Strings;

import java.util.StringJoiner;

import static java.util.Arrays.asList;

public class Examples {

    public static void main(String[] args) {

        String join = new StringJoiner(",")
                .add("a")
                .add("b")
                .add("c")
                .toString();

        assert join.equals("a,b,c");

        join = String.join(",", asList("a", "b", "c"));
        assert join.equals("a,b,c");
    }

}
