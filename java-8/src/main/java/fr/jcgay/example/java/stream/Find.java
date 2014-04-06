package fr.jcgay.example.java.stream;

import fr.jcgay.example.java.Person;

import java.util.List;

import static java.util.Arrays.asList;

public class Find {

    public static void main(String[] args) {

        List<Person> persons = asList(
                new Person("John", "Doe", 30),
                new Person("Jane", "Doe", 20),
                new Person("Jim", "Smith", 15)
        );

        persons.stream()
                .findFirst()
                .ifPresent(System.out::print);

        persons.stream()
                .parallel()
                .findAny()
                .ifPresent(System.out::print);
    }
}
