package fr.jcgay.example.java.stream;

import fr.jcgay.example.java.Person;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Examples {

    public static void main(String[] args) {

        List<Person> persons = asList(
                new Person("John", "Doe", 30),
                new Person("Jane", "Doe", 20),
                new Person("Jim", "Smith", 15)
        );

        assert persons.stream().count() == 3;

        assert IntStream.range(0, 10).sum() == 45;

        Stream.of("a", "b", "c").forEach(System.out::println);

        Stream.builder().add("a").add("b").add("c")
                .build()
                .forEach(System.out::println);

        Random random = new Random();
        Stream.generate(() -> random.nextInt())
                .limit(10)
                .forEach(System.out::println);

        new Random().ints()
                .limit(10)
                .forEach(System.out::println);
    }
}
