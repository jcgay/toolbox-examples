package fr.jcgay.example.java.stream;

import fr.jcgay.example.java.Person;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Collect {

    public static void main(String[] args) {

        List<Person> persons = asList(
                new Person("John", "Doe", 30),
                new Person("Jane", "Doe", 20),
                new Person("Jim", "Smith", 15)
        );

        List<String> result = persons.stream()
                .map(Person::getLastName)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
