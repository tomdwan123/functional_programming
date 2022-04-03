package com.phucdevs.streams;

import com.phucdevs.functional_model.Gender;
import com.phucdevs.functional_model.Person;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * @author Phuc.Le
 */
public class _Stream {

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Phuc", Gender.MALE),
                new Person("Tinh", Gender.FEMALE),
                new Person("Hoang", Gender.MALE),
                new Person("Chau", Gender.FEMALE),
                new Person("Long", Gender.MALE),
                new Person("Bob", Gender.PREFER_NOT_TO_SAY)
        );

        System.out.println("get list gender with stream: ");
        persons.stream()
                .map(Person::getGender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("get length og list name by stream");
        Function<Person, String> personStringFunction = Person::getName;
        ToIntFunction<String> length = String::length;
        IntConsumer println = x -> System.out.println(x);

        persons.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        System.out.println("check list all contain female");
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.getGender());
        boolean isContainAllFemale = persons.stream()
                .allMatch(personPredicate);

        System.out.println(isContainAllFemale);

        System.out.println("check list contains any female");
         boolean isContainAnyFemale = persons.stream()
                 .anyMatch(person -> Gender.FEMALE.equals(person.getGender()));

        System.out.println(isContainAnyFemale);

        System.out.println("check list not contains prefer_not_to_say");
        boolean isNoneMatchPrefer = persons.stream()
                .noneMatch(person -> Gender.PREFER_NOT_TO_SAY.equals(person.getGender()));

        System.out.println(isNoneMatchPrefer);
    }
}
