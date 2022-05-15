package com.phucdevs.lamda_example;

import java.util.function.Function;

/**
 * @author Phuc.Le
 */
public class FluentInterface {

    private static void printInt(int n,
                                 String msg,
                                 Function<Integer, Integer> func) {
        System.out.println(n + " " + msg + " " + func.apply(n));
    }

    public static void callPrintIncremented() {
        Function<Integer, Integer> inc = e -> e + 1;
        printInt(5, "incremented", inc);
    }

    public static void callPrintDoubled() {
        Function<Integer, Integer> doubled = e -> e * 2;
        printInt(5, "doubled", doubled);
    }

    public static void callPrintIncrementedAndDoubled() {
        Function<Integer, Integer> inc = e -> e + 1;
        Function<Integer, Integer> doubled = e -> e * 2;

        printInt(5, "incremented and doubled ", inc.andThen(doubled));
    }
}
