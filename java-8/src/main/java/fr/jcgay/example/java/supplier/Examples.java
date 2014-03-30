package fr.jcgay.example.java.supplier;

import java.util.function.Supplier;

public class Examples {

    public static void main(String[] args) {

        Supplier<String> emptyString = () -> "";

        assert "".equals(emptyString.get());
    }
}
