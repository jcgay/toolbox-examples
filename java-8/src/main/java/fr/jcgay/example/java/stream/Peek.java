package fr.jcgay.example.java.stream;

import fr.jcgay.example.java.Person;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Peek {

    public static void main(String[] args) {

        List<Person> persons = asList(
                new Person("John", "Doe", 30),
                new Person("Jane", "Doe", 20),
                new Person("Jim", "Smith", 15)
        );

        persons.stream()
                .filter(p -> "Doe".equals(p.getLastName()))
                .peek(System.out::println)
                .filter(p -> p.getAge() < 25)
                .peek(System.out::println)
                .collect(Collectors.toSet());
    }
}
