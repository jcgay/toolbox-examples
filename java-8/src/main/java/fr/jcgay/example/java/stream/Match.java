package fr.jcgay.example.java.stream;

import fr.jcgay.example.java.Person;

import java.util.List;

import static java.util.Arrays.asList;

public class Match {

    public static void main(String[] args) {

        List<Person> persons = asList(
                new Person("John", "Doe", 30),
                new Person("Jane", "Doe", 20),
                new Person("Jim", "Smith", 15)
        );

        assert persons.stream()
                .allMatch(p -> p.getFirstName().startsWith("J"))
            == true;

        assert persons.stream()
                .noneMatch(p -> p.getAge() == 35)
            == true;

        assert persons.stream()
                .anyMatch(p -> "Doe".equals(p.getLastName()))
            == true;
    }
}
