package fr.jcgay.example.java.functional_interface;

@FunctionalInterface
public interface Function<T, R> {

    R apply(T t);
}
