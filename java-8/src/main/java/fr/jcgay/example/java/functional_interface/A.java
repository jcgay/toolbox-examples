package fr.jcgay.example.java.functional_interface;

@FunctionalInterface
public interface A {

    default void printSomething() {
        System.out.println("something");
    }

    void print();
}
