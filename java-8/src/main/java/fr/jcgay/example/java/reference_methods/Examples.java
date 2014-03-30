package fr.jcgay.example.java.reference_methods;

import fr.jcgay.example.java.functional_interface.Function;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Examples {

    public static void main(String[] args) {

        Function<Integer, String> toString = String::valueOf;
        assert "4".equals(toString.apply(4));

        String hello = new String("hello");
        Predicate<String> startsWith = hello::startsWith;

        assert startsWith.test("he") == true;

        Supplier<String> newString = String::new;

        List<String> names = Arrays.asList("James", "Mary", "John", "Barbara");
        Collections.sort(names, String::compareToIgnoreCase);
        System.out.println(names);
    }
}
