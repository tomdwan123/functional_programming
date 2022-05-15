package com.phucdevs.lamda_example;

import java.util.function.Supplier;

/**
 * @author Phuc.Le
 */

class Lazy<T> {

    private T instance;
    private Supplier<T> supplier;

    public Lazy(Supplier<T> supplier) { this.supplier = supplier; }

    public T get() {

        if (instance == null) {
            instance = supplier.get();
            supplier = null;
        }

        return instance;
    }
}


public class LazyExample {

    public static int compute(int n) {
        System.out.println("called...");
        return n * 2;
    }

    public static void calWithNonLamdaCompute() {
        int n = 4;

        if (n > 5 && n * 2 > 7) {
            System.out.println("Path 1");
        } else {
            System.out.println("Path 2");
        }
    }

    public static void calWithLazyLamdaNoValueCompute() {
        int n = 4;
        var temp = new Lazy<Integer>(() -> compute(n));

        if (n > 5 && temp.get() > 7) {
            System.out.println("Path 1");
        } else {
            System.out.println("Path 2");
        }
    }

    public static void calWithLazyLamdaHasValueCompute() {
        int n = 14;
        var computeValue = new Lazy<Integer>(() -> compute(n));
        System.out.println("here...");

        if (n > 5 && computeValue.get() > 7) {
            System.out.println("Path 1 " + computeValue.get());
        } else {
            System.out.println("Path 2");
        }
    }
}
