package com.phucdevs.lamda_example;

import java.util.List;

/**
 * @author Phuc.Le
 */
public class Main {

    public static void main(String[] args) {
        //callTotalValue();
        //callLamdaCompute();
        callFluentInterface();
    }

    static void callTotalValue() {
        List<Integer> values = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Way 1");
        System.out.println(TotalValueExample.totalValueBasic(values));
        System.out.println(TotalValueExample.totalEvenValueBasic(values));
        System.out.println(TotalValueExample.totalOddValueBasic(values));

        System.out.println("Way 2");
        System.out.println(TotalValueExample.totalValuePro(values, e -> true));
        System.out.println(TotalValueExample.totalValuePro(values, e -> e % 2 == 0));
        System.out.println(TotalValueExample.totalValuePro(values, e -> e % 2 != 0));
    }

    static void callLamdaCompute() {
        System.out.println("Way no lamda");
        LazyExample.calWithNonLamdaCompute(); // Path 2

        System.out.println("Way with lazy lamda no value");
         LazyExample.calWithLazyLamdaNoValueCompute(); // Path 2

        System.out.println("Way with lazy lamda has value");
        LazyExample.calWithLazyLamdaHasValueCompute(); // here... called... Path 1 + 28
    }

    static void callFluentInterface() {
        FluentInterface.callPrintIncremented(); // 5 incremented 6
        FluentInterface.callPrintDoubled(); // 5 doubled 10
        FluentInterface.callPrintIncrementedAndDoubled(); // 5 incremented and doubled 12
    }
}
