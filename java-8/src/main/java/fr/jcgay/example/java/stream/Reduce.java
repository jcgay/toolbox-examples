package fr.jcgay.example.java.stream;

import fr.jcgay.example.java.Person;

import java.util.List;

import static java.util.Arrays.asList;

public class Reduce {

    public static void main(String[] args) {

        List<Person> persons = asList(
                new Person("John", "Doe", 30),
                new Person("Jane", "Doe", 20),
                new Person("Jim", "Smith", 15)
        );

        persons.stream()
                .reduce((p1, p2) -> new Person(p1.getFirstName(), p2.getLastName(), p1.getAge() + p2.getAge()))
                .ifPresent(System.out::println);

        assert persons.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum)
            == 65;

        assert persons.stream()
                .reduce(0,
                        (result, person) -> result + person.getAge(),
                        (a, b) -> a + b
                )
            == 65;
    }
}
