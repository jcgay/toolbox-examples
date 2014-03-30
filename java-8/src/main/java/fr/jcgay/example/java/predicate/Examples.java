package fr.jcgay.example.java.predicate;

import java.util.function.Predicate;

public class Examples {

    public static void main(String[] args) {

        Predicate<String> isEmpty = s -> s == null || s.isEmpty();
        Predicate<String> isTrimmed = s -> s.equals(s.trim());

        assert isEmpty.test(null) == true;
        assert isEmpty.test("") == true;
        assert isEmpty.test("not empty") == false;

        assert isEmpty.negate().and(isTrimmed).test("not empty") == true;
        assert isEmpty.negate().and(isTrimmed).test(" not empty ") == false;

        assert isEmpty.or(isTrimmed).test("") == true;
        assert isEmpty.or(isTrimmed).test("not empty") == true;

        assert Predicate.isEqual("hello").test("hello") == true;
    }
}
