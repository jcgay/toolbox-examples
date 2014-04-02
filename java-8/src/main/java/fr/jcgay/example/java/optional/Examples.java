package fr.jcgay.example.java.optional;

import java.util.Optional;

public class Examples {

    public static void main(String[] args) {

        Optional<String> hello = Optional.of("hello");
        assert hello.isPresent() == true;
        assert "hello".equals(hello.get());

        Optional<Object> absent = Optional.ofNullable(null);

        assert absent.isPresent() == false;
        absent.get();
    }
}
