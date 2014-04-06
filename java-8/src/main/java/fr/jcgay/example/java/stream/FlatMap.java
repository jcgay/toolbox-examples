package fr.jcgay.example.java.stream;

import fr.jcgay.example.java.Person;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class FlatMap {

    public static void main(String[] args) {

    Stream.<List<Person>>builder()
            .add(asList(new Person("John", "Doe", 30), new Person("Jane", "Doe", 20)))
            .add(asList(new Person("Jim", "Smith", 15)))
            .build()
            .flatMap(persons -> persons.stream())
            .filter(person -> "Doe".equals(person.getLastName()))
            .forEach(System.out::println);
    }
}
