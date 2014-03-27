package fr.jcgay.example.java.default_methods;

public interface B {

    default void printSomething() {
        System.out.println("something else");
    }
}
