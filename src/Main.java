import com.phucdevs.functional_model.Gender;
import com.phucdevs.functional_model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Phuc.Le
 */
public class Main {

    public static void main(String[] args) {

        List<Person> persons = List.of(
                new Person("Phuc", Gender.MALE),
                new Person("Tinh", Gender.FEMALE),
                new Person("Hoang", Gender.MALE),
                new Person("Chau", Gender.FEMALE),
                new Person("Long", Gender.MALE)
        );

        System.out.println("Imperative approach");
        imperativeApproach(persons);

        System.out.println("Declarative approach 1");
        declarativeApproachV1(persons);

        System.out.println("Declarative approach 2");
        declarativeApproachV2(persons);
    }

    static void imperativeApproach(List<Person> persons) {
        List<Person> males = new ArrayList<>();
        for (Person person : persons) {
            if (Gender.MALE.equals(person.getGender())) {
                males.add(person);
            }
        }

        for (Person female : males) {
            System.out.println(female);
        }
    }

    static void declarativeApproachV1(List<Person> persons) {
        persons.stream()
                .filter(person -> Gender.MALE.equals(person.getGender()))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    static void declarativeApproachV2(List<Person> persons) {
        Predicate<Person> personPredicate = person -> Gender.MALE.equals(person.getGender());
        List<Person> males2 = persons.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
        males2.forEach(System.out::println);
    }


}
