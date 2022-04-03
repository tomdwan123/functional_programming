package com.phucdevs.optionals;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Phuc.Le
 */
public class Main {

    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

        System.out.println(value);

        Supplier<IllegalStateException> exception = ()
                -> new IllegalStateException("exception");

        Object value2 = Optional.ofNullable("hello")
                .orElseThrow(exception);

        System.out.println(value2);

        Optional.ofNullable("john@gmail.com")
                .ifPresent(System.out::println);

        Optional.ofNullable("john@gmail.com")
                .ifPresent(email
                        -> System.out.println("Sending email to " + email));

        Optional.ofNullable("john@gmail.com")
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email to")
                );
    }
}
