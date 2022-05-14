package com.phucdevs.lamda_example;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Phuc.Le
 */
public class TotalValueExample {

    public static int totalValueBasic(List<Integer> values) {

        int total = 0;

        for (int v : values) {
            total += v;
        }

        return total;
    }

    public static int totalEvenValueBasic(List<Integer> values) {

        int total = 0;

        for (int v : values) {
            if (v % 2 == 0) total += v;
        }

        return total;
    }

    public static int totalOddValueBasic(List<Integer> values) {

        int total = 0;

        for (int v : values) {
            if (v % 2 != 0) total += v;
        }

        return total;
    }

    public static int totalValuePro(List<Integer> values,
                                    Predicate<Integer> selector) {

        return values.stream()
                .filter(selector)
                .mapToInt(v -> v)
                .sum();
    }
}
