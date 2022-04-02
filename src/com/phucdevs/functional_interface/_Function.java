package com.phucdevs.functional_interface;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Phuc.Le
 */
public class _Function {

    public static void main(String[] args) {
        // Function takes 1 argument and produces 1 result
        int increment1 = incrementByOne(1);
        System.out.println("Increment by basic: " + increment1);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println("Increment by Function: " + increment2);

        int multiply = multiplyByTenFunction.apply(increment2);
        System.out.println("Multiply: " + multiply);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyByTenFunction);
        System.out.println("Increment and then Multiply: " + addBy1AndThenMultiplyBy10.apply(4));

        // BiFunction takes 2 arguments and produces 1 result
        System.out.println(
                incrementByOneAndMultiply(4, 100)
        );
        System.out.println(
                incrementByOneAndMultiplyBiFunction.apply(4, 100)
        );
    }

    static int incrementByOne(int number) {
        return number + 1;
    }

    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyByTenFunction =
            number -> number * 10;

    static int incrementByOneAndMultiply(int number, int numberToMultiply) {
        return  (number + 1) * numberToMultiply;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiply)
                    -> (numberToIncrementByOne + 1) * numberToMultiply;
}
