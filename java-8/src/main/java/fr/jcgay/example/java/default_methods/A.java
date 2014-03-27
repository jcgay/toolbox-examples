package fr.jcgay.example.java.default_methods;

public interface A {

    default void printSomething() {
        System.out.println("something");
    }
}
